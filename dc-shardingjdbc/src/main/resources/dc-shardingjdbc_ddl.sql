CREATE DATABASE  IF NOT EXISTS `dcorder-00` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dcorder-00`;

-- Table structure for table `t_order_0000`
--

DROP TABLE IF EXISTS `t_order_0000`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order_0000` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL,
  `order_no` varchar(256) NOT NULL COMMENT '名称',
  `service_name` varchar(190) DEFAULT NULL COMMENT '外部服务名',
  `creator` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
  `modifier` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '修改者',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除 Y：是  N：否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_order_0001`
--

DROP TABLE IF EXISTS `t_order_0001`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order_0001` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL,
  `order_no` varchar(256) NOT NULL COMMENT '名称',
  `service_name` varchar(190) DEFAULT NULL COMMENT '外部服务名',
  `creator` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
  `modifier` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '修改者',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除 Y：是  N：否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_order_0002`
--

DROP TABLE IF EXISTS `t_order_0002`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order_0002` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL,
  `order_no` varchar(256) NOT NULL COMMENT '名称',
  `service_name` varchar(190) DEFAULT NULL COMMENT '外部服务名',
  `creator` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
  `modifier` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '修改者',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除 Y：是  N：否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_order_0003`
--

DROP TABLE IF EXISTS `t_order_0003`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order_0003` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL,
  `order_no` varchar(256) NOT NULL COMMENT '名称',
  `service_name` varchar(190) DEFAULT NULL COMMENT '外部服务名',
  `creator` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
  `modifier` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '修改者',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除 Y：是  N：否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-07 15:57:14
CREATE DATABASE  IF NOT EXISTS `dcorder-01` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dcorder-01`;
-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: dcorder-01
-- ------------------------------------------------------
-- Server version	5.7.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_order_0004`
--

DROP TABLE IF EXISTS `t_order_0004`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order_0004` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL,
  `order_no` varchar(256) NOT NULL COMMENT '名称',
  `service_name` varchar(190) DEFAULT NULL COMMENT '外部服务名',
  `creator` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
  `modifier` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '修改者',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除 Y：是  N：否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_order_0005`
--

DROP TABLE IF EXISTS `t_order_0005`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order_0005` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL,
  `order_no` varchar(256) NOT NULL COMMENT '名称',
  `service_name` varchar(190) DEFAULT NULL COMMENT '外部服务名',
  `creator` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
  `modifier` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '修改者',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除 Y：是  N：否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_order_0006`
--

DROP TABLE IF EXISTS `t_order_0006`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order_0006` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL,
  `order_no` varchar(256) NOT NULL COMMENT '名称',
  `service_name` varchar(190) DEFAULT NULL COMMENT '外部服务名',
  `creator` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
  `modifier` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '修改者',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除 Y：是  N：否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_order_0007`
--

DROP TABLE IF EXISTS `t_order_0007`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order_0007` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL,
  `order_no` varchar(256) NOT NULL COMMENT '名称',
  `service_name` varchar(190) DEFAULT NULL COMMENT '外部服务名',
  `creator` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
  `modifier` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '修改者',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除 Y：是  N：否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-07 15:57:14
CREATE DATABASE  IF NOT EXISTS `dcorder-02` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dcorder-02`;
-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: dcorder-02
-- ------------------------------------------------------
-- Server version	5.7.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_order_0008`
--

DROP TABLE IF EXISTS `t_order_0008`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order_0008` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL,
  `order_no` varchar(256) NOT NULL COMMENT '名称',
  `service_name` varchar(190) DEFAULT NULL COMMENT '外部服务名',
  `creator` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
  `modifier` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '修改者',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除 Y：是  N：否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_order_0009`
--

DROP TABLE IF EXISTS `t_order_0009`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order_0009` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL,
  `order_no` varchar(256) NOT NULL COMMENT '名称',
  `service_name` varchar(190) DEFAULT NULL COMMENT '外部服务名',
  `creator` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
  `modifier` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '修改者',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除 Y：是  N：否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_order_0010`
--

DROP TABLE IF EXISTS `t_order_0010`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order_0010` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL,
  `order_no` varchar(256) NOT NULL COMMENT '名称',
  `service_name` varchar(190) DEFAULT NULL COMMENT '外部服务名',
  `creator` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
  `modifier` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '修改者',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除 Y：是  N：否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_order_0011`
--

DROP TABLE IF EXISTS `t_order_0011`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order_0011` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL,
  `order_no` varchar(256) NOT NULL COMMENT '名称',
  `service_name` varchar(190) DEFAULT NULL COMMENT '外部服务名',
  `creator` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
  `modifier` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '修改者',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除 Y：是  N：否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-07 15:57:14
CREATE DATABASE  IF NOT EXISTS `dcorder-03` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dcorder-03`;
-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: dcorder-03
-- ------------------------------------------------------
-- Server version	5.7.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_order_0012`
--

DROP TABLE IF EXISTS `t_order_0012`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order_0012` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL,
  `order_no` varchar(256) NOT NULL COMMENT '名称',
  `service_name` varchar(190) DEFAULT NULL COMMENT '外部服务名',
  `creator` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
  `modifier` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '修改者',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除 Y：是  N：否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_order_0013`
--

DROP TABLE IF EXISTS `t_order_0013`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order_0013` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL,
  `order_no` varchar(256) NOT NULL COMMENT '名称',
  `service_name` varchar(190) DEFAULT NULL COMMENT '外部服务名',
  `creator` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
  `modifier` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '修改者',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除 Y：是  N：否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_order_0014`
--

DROP TABLE IF EXISTS `t_order_0014`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order_0014` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL,
  `order_no` varchar(256) NOT NULL COMMENT '名称',
  `service_name` varchar(190) DEFAULT NULL COMMENT '外部服务名',
  `creator` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
  `modifier` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '修改者',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除 Y：是  N：否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_order_0015`
--

DROP TABLE IF EXISTS `t_order_0015`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order_0015` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL,
  `order_no` varchar(256) NOT NULL COMMENT '名称',
  `service_name` varchar(190) DEFAULT NULL COMMENT '外部服务名',
  `creator` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建者',
  `modifier` varchar(64) NOT NULL DEFAULT 'SYSTEM' COMMENT '修改者',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除 Y：是  N：否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-07 15:57:14
