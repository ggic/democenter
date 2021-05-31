package com.snoweagle.dc.redis.app;


import com.snoweagle.dc.redis.infra.redis.RedisService;
import com.snoweagle.dc.redis.infra.utils.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/cache")
@Slf4j
public class DemoController  {

    public static final long EXPIRE_SECONDS =30;
    @Autowired
    RedisService redisService;

    @Autowired
    RedissonClient redissonClient;

    @GetMapping(value = "put/{id}/{text}")
    public String put(@PathVariable String id ,@PathVariable String text){
        redisService.set(id ,text, EXPIRE_SECONDS, TimeUnit.SECONDS);
        Object value = redisService.get(id);
        return GsonUtils.BeanToJson(value);
    }

    @GetMapping(value = "/health")
    public String health()  {
        return GsonUtils.BeanToJson("i'm ok !");
    }

    /**
     * lock for waitting
     * @param id
     * @return
     */
    @GetMapping(value = "disLock/{id}")
    public String disLock(@PathVariable String id ){
        RLock lock = redissonClient.getLock("lock-product:10000");
        try {
            //当leaseTime没有设置，默认30秒，且开启watchdog，每过10秒做一次续约直到线程任务跑完位置，才释放锁
            //other thread waitting for curthread release lock
            lock.lock();
            int i = Integer.parseInt(String.valueOf(redisService.get(id)));
            log.info("当前库存,i:{}",i);
            if(i>0){
                i--;
                redisService.set(id,i);
                log.info("减库存,i:{}",i);
            }else {
                log.info("没有库存.i:{}",i);
            }
        }catch (Exception e){
            log.error(e.getMessage(),e);
        } finally {
            if(lock.isLocked()){
                lock.unlock();

            }
        }
        return GsonUtils.BeanToJson("ok");
    }

    /**
     * try lock
     * @param id
     * @return
     */
    @GetMapping(value = "tryDisLock/{id}")
    public String tryDisLock(@PathVariable String id ){
        RLock lock = redissonClient.getLock("lock-product:20000");
        boolean holdLock =false;
        try {
            //not waitting ,return true means get lock,else not .
            holdLock = lock.tryLock();
            if(holdLock) {
                int i = Integer.parseInt(String.valueOf(redisService.get(id)));
                log.info("当前库存,i:{}", i);
                if (i > 0) {
                    i--;
                    redisService.set(id, i);
                    log.info("减库存,i:{}", i);
                } else {
                    log.info("没有库存.i:{}", i);
                }
            }
        }catch (Exception e){
            log.error(e.getMessage(),e);
        } finally {
            if(holdLock){
                lock.unlock();

            }
        }
        return GsonUtils.BeanToJson("ok");
    }

}
