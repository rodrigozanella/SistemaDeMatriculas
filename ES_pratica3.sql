CREATE DATABASE  IF NOT EXISTS `es_pratica3` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `es_pratica3`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: es_pratica3
-- ------------------------------------------------------
-- Server version	5.6.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluno` (
  `cpf` varchar(45) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `nomeUsuario` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `pontuacao` int(11) NOT NULL,
  `alunocol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cpf`),
  UNIQUE KEY `nomeUsuario_UNIQUE` (`nomeUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES ('010.325.689-02','Rofrigo Zanella','rzanella','a45de2','rodrigo@exemplo.com',500,NULL),('025.180.450-56','Henrique Dambros','hdambros','d54s6','hvdambros@gmail.com',450,NULL),('100.252.666-99','Paulo dos Santos','psantos','456gt78','paulo@uol.com',300,NULL);
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disciplina` (
  `codigo` varchar(45) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `ehEletiva` bit(1) NOT NULL,
  `numCreditos` int(11) NOT NULL,
  `numCreditosMin` int(11) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina`
--

LOCK TABLES `disciplina` WRITE;
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
INSERT INTO `disciplina` VALUES ('INF01023','Arquitetura e Desempenho de Banco de Dados','',4,0),('INF01032','Empreendimento em Informática','\0',4,88),('INF01120','Técnicas de Construção de Programas','\0',4,0),('INF01124','Classificação e Pesquisa de Dados','\0',4,0),('INF01142','Sistemas Operacionais I N','\0',4,0),('INF01145','Fundamentos de Banco de Dados','\0',4,0),('INF01147','Compiladores','\0',4,0),('INF01209','Fundamentos de Tolerância a Falhas','\0',4,0),('INF05516','Semântica Formal N','\0',4,0);
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pre_requisitos`
--

DROP TABLE IF EXISTS `pre_requisitos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pre_requisitos` (
  `codigoDisciplina` varchar(45) NOT NULL,
  `codigoDisciplinaRequisito` varchar(45) NOT NULL,
  PRIMARY KEY (`codigoDisciplina`,`codigoDisciplinaRequisito`),
  KEY `codigoDisciplinaRequisito_idx` (`codigoDisciplinaRequisito`),
  CONSTRAINT `codigoDisciplina2` FOREIGN KEY (`codigoDisciplina`) REFERENCES `disciplina` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codigoDisciplinaRequisito` FOREIGN KEY (`codigoDisciplinaRequisito`) REFERENCES `disciplina` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pre_requisitos`
--

LOCK TABLES `pre_requisitos` WRITE;
/*!40000 ALTER TABLE `pre_requisitos` DISABLE KEYS */;
INSERT INTO `pre_requisitos` VALUES ('INF01145','INF01124'),('INF01209','INF01142'),('INF01147','INF05516');
/*!40000 ALTER TABLE `pre_requisitos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professor` (
  `cpf` varchar(45) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `email` varchar(45) NOT NULL,
  `nomeUsuario` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES ('001.002.003-04','Marcelo Pimenta','mpimenta@inf.ufrgs.br','mpimenta','k29fj8'),('003.669.876-26','Manuel Oliveira','moliveira@inf.ufrgs.br','moliveira','a23d92'),('025.301.254-56','Mariana Luderitz Kolberg','mlkolberg@inf.ufrgs.br','mlkolberg','l91h11'),('032.256.215-89','Taisy Silva Weber','tsweber@inf.ufrgs.br','tsweber','js2h3'),('123.456.789-10','Sérgio Cechin','scechin@inf.ufrgs.br','scechin','j2s023'),('125.254.698-00','Lucas Schnorr','lschnorr@inf.ufrgs.br','lschnorr','r18d83'),('154.258.548-12','Cirano Iochpe','ciochpe@inf.ufrgs.br','cioshpe','h29dh9'),('501.254.328-98','Luciana Porcher Nedel','lpnedel@inf.ufrgs.br','lpnedel','j28dh9');
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma`
--

DROP TABLE IF EXISTS `turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turma` (
  `idturma` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` char(1) NOT NULL,
  `codigoDisciplina` varchar(45) NOT NULL,
  `horario` varchar(45) NOT NULL,
  `semestre` varchar(45) NOT NULL,
  `numvagas` int(11) NOT NULL,
  `cpfProfessor` varchar(45) NOT NULL,
  PRIMARY KEY (`idturma`),
  KEY `codigoDisciplina_idx` (`codigoDisciplina`),
  KEY `cpfProfessor_idx` (`cpfProfessor`),
  CONSTRAINT `codigoDisciplina` FOREIGN KEY (`codigoDisciplina`) REFERENCES `disciplina` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cpfProfessor` FOREIGN KEY (`cpfProfessor`) REFERENCES `professor` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma`
--

LOCK TABLES `turma` WRITE;
/*!40000 ALTER TABLE `turma` DISABLE KEYS */;
INSERT INTO `turma` VALUES (1,'A','INF01124','10:30','2013/2',40,'003.669.876-26'),(2,'B','INF01124','8:30','2013/2',25,'003.669.876-26'),(3,'A','INF01124','13:30','2013/1',30,'003.669.876-26'),(4,'A','INF01124','10:30','2012/2',30,'003.669.876-26'),(5,'A','INF01124','13:30','2012/1',25,'003.669.876-26'),(6,'A','INF05516','10:30','2013/2',25,'025.301.254-56'),(7,'B','INF05516','8:30','2013/2',20,'025.301.254-56'),(8,'A','INF05516','8:30','2013/1',20,'025.301.254-56'),(9,'B','INF05516','13:30','2013/1',20,'025.301.254-56'),(10,'A','INF05516','13:30','2012/2',20,'025.301.254-56'),(11,'A','INF05516','10:30','2012/1',30,'025.301.254-56'),(12,'A','INF01209','8:30','2013/2',15,'032.256.215-89'),(13,'C','INF01209','15:30','2013/2',10,'032.256.215-89'),(14,'D','INF01209','17:30','2013/1',5,'032.256.215-89'),(15,'B','INF01209','10:30','2012/2',15,'032.256.215-89'),(16,'A','INF01209','15:30','2012/1',5,'032.256.215-89'),(17,'E','INF01209','19:30','2011/2',50,'032.256.215-89'),(18,'A','INF01147','13:30','2013/2',20,'125.254.698-00'),(19,'D','INF01147','10:30','2013/2',15,'125.254.698-00'),(20,'C','INF01147','8:30','2013/1',20,'125.254.698-00'),(21,'B','INF01147','10:30','2013/1',15,'125.254.698-00'),(22,'A','INF01147','13:30','2012/2',30,'125.254.698-00'),(23,'B','INF01147','8:30','2012/1',15,'125.254.698-00'),(24,'A','INF01145','13:30','2013/2',30,'154.258.548-12'),(25,'C','INF01145','10:30','2013/2',20,'154.258.548-12'),(26,'C','INF01145','8:30','2013/1',15,'154.258.548-12'),(27,'A','INF01145','13:30','2012/2',20,'154.258.548-12'),(28,'A','INF01142','13:30','2013/2',35,'123.456.789-10'),(29,'B','INF01142','10:30','2013/2',30,'123.456.789-10'),(30,'A','INF01142','10:30','2013/1',40,'123.456.789-10'),(31,'C','INF01142','8:30','2012/2',15,'123.456.789-10'),(32,'A','INF01120','15:30','2013/2',30,'001.002.003-04'),(33,'B','INF01120','13:30','2013/2',15,'001.002.003-04'),(34,'A','INF01120','8:30','2013/1',20,'001.002.003-04'),(35,'F','INF01120','10:30','2012/2',5,'001.002.003-04'),(36,'U','INF01032','8:30','2013/2',15,'501.254.328-98'),(37,'G','INF01032','13:30','2013/1',5,'501.254.328-98'),(38,'U','INF01032','15:30','2012/2',10,'501.254.328-98'),(39,'U','INF01032','13:30','2012/1',20,'501.254.328-98'),(40,'U','INF01023','15:30','2013/2',20,'154.258.548-12'),(41,'F','INF01023','13:30','2013/1',15,'154.258.548-12'),(42,'U','INF01023','8:30','2012/2',25,'154.258.548-12'),(43,'U','INF01023','15:30','2011/2',15,'154.258.548-12');
/*!40000 ALTER TABLE `turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turmas_cursadas`
--

DROP TABLE IF EXISTS `turmas_cursadas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turmas_cursadas` (
  `cpfAluno` varchar(45) NOT NULL,
  `idTurma` int(11) NOT NULL,
  `conceito` char(1) DEFAULT NULL,
  PRIMARY KEY (`cpfAluno`,`idTurma`),
  KEY `idTurma_idx` (`idTurma`),
  CONSTRAINT `cpfAluno` FOREIGN KEY (`cpfAluno`) REFERENCES `aluno` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idTurma` FOREIGN KEY (`idTurma`) REFERENCES `turma` (`idturma`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turmas_cursadas`
--

LOCK TABLES `turmas_cursadas` WRITE;
/*!40000 ALTER TABLE `turmas_cursadas` DISABLE KEYS */;
INSERT INTO `turmas_cursadas` VALUES ('010.325.689-02',5,'A'),('010.325.689-02',14,'A'),('010.325.689-02',27,'C'),('025.180.450-56',10,'B'),('025.180.450-56',42,'A'),('100.252.666-99',30,'C'),('100.252.666-99',35,'C'),('100.252.666-99',39,'B');
/*!40000 ALTER TABLE `turmas_cursadas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-10-16 23:20:37
