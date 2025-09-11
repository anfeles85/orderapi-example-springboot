-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.33 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.11.0.7065
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para academy_db
CREATE DATABASE IF NOT EXISTS `academy_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `academy_db`;

-- Volcando estructura para tabla academy_db.categories
CREATE TABLE IF NOT EXISTS `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` text,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla academy_db.categories: ~4 rows (aproximadamente)
INSERT INTO `categories` (`id`, `name`, `description`, `created_at`, `updated_at`) VALUES
	(1, 'Programación', 'Cursos sobre lenguajes de programación y desarrollo de software.', '2025-09-11 20:58:04', '2025-09-11 20:58:04'),
	(2, 'Diseño Gráfico', 'Cursos sobre diseño, ilustración y herramientas como Photoshop o Figma.', '2025-09-11 20:58:04', '2025-09-11 20:58:04'),
	(3, 'Marketing Digital', 'Estrategias de marketing en redes sociales, SEO y publicidad online.', '2025-09-11 20:58:04', '2025-09-11 20:58:04'),
	(4, 'Data Science', 'Análisis de datos, machine learning e inteligencia artificial.', '2025-09-11 20:58:04', '2025-09-11 20:58:04');

-- Volcando estructura para tabla academy_db.courses
CREATE TABLE IF NOT EXISTS `courses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `description` text,
  `price` decimal(8,2) DEFAULT NULL,
  `instructor_id` int NOT NULL,
  `category_id` int DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `instructor_id` (`instructor_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `courses_ibfk_1` FOREIGN KEY (`instructor_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  CONSTRAINT `courses_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla academy_db.courses: ~5 rows (aproximadamente)
INSERT INTO `courses` (`id`, `title`, `description`, `price`, `instructor_id`, `category_id`, `created_at`, `updated_at`) VALUES
	(1, 'Desarrollo Web con Laravel', 'Aprende a construir APIs REST con Laravel.', 49.99, 1, 1, '2025-09-11 20:58:04', '2025-09-11 20:58:04'),
	(2, 'Introducción a Python', 'Curso básico de programación en Python.', 39.99, 1, 1, '2025-09-11 20:58:04', '2025-09-11 20:58:04'),
	(3, 'Diseño UI/UX con Figma', 'Crea interfaces modernas usando Figma.', 59.99, 2, 2, '2025-09-11 20:58:04', '2025-09-11 20:58:04'),
	(4, 'Marketing en Instagram', 'Estrategias efectivas para crecer en Instagram.', 45.00, 3, 3, '2025-09-11 20:58:04', '2025-09-11 20:58:04'),
	(5, 'Análisis de Datos con Pandas', 'Manipulación y análisis de datos en Python.', 65.00, 1, 4, '2025-09-11 20:58:04', '2025-09-11 20:58:04');

-- Volcando estructura para tabla academy_db.enrollments
CREATE TABLE IF NOT EXISTS `enrollments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` int NOT NULL,
  `course_id` int NOT NULL,
  `enrollment_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `status` enum('active','completed','dropped') DEFAULT 'active',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_enrollment` (`student_id`,`course_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `enrollments_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  CONSTRAINT `enrollments_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla academy_db.enrollments: ~8 rows (aproximadamente)
INSERT INTO `enrollments` (`id`, `student_id`, `course_id`, `enrollment_date`, `status`) VALUES
	(1, 4, 1, '2025-09-11 20:58:04', 'active'),
	(2, 4, 2, '2025-09-11 20:58:04', 'completed'),
	(3, 4, 5, '2025-09-11 20:58:04', 'active'),
	(4, 5, 3, '2025-09-11 20:58:04', 'active'),
	(5, 5, 1, '2025-09-11 20:58:04', 'active'),
	(6, 6, 4, '2025-09-11 20:58:04', 'active'),
	(7, 7, 2, '2025-09-11 20:58:04', 'active'),
	(8, 7, 5, '2025-09-11 20:58:04', 'completed');

-- Volcando estructura para tabla academy_db.lessons
CREATE TABLE IF NOT EXISTS `lessons` (
  `id` int NOT NULL AUTO_INCREMENT,
  `course_id` int NOT NULL,
  `title` varchar(200) NOT NULL,
  `content` text,
  `order_number` int DEFAULT '0',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_lesson_order` (`course_id`,`order_number`),
  CONSTRAINT `lessons_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla academy_db.lessons: ~8 rows (aproximadamente)
INSERT INTO `lessons` (`id`, `course_id`, `title`, `content`, `order_number`, `created_at`, `updated_at`) VALUES
	(1, 1, 'Instalación de Laravel', 'En este video aprenderás a instalar Laravel usando Composer.', 1, '2025-09-11 20:58:04', '2025-09-11 20:58:04'),
	(2, 1, 'Rutas y Controladores', 'Creación de rutas y controladores para una API REST.', 2, '2025-09-11 20:58:04', '2025-09-11 20:58:04'),
	(3, 1, 'Eloquent ORM', 'Cómo usar Eloquent para interactuar con la base de datos.', 3, '2025-09-11 20:58:04', '2025-09-11 20:58:04'),
	(4, 2, 'Variables y Tipos de Datos', 'Conceptos básicos de variables en Python.', 1, '2025-09-11 20:58:04', '2025-09-11 20:58:04'),
	(5, 2, 'Bucles y Condicionales', 'Uso de if, for y while.', 2, '2025-09-11 20:58:04', '2025-09-11 20:58:04'),
	(6, 3, 'Interfaz de Figma', 'Navegación por el entorno de trabajo.', 1, '2025-09-11 20:58:04', '2025-09-11 20:58:04'),
	(7, 3, 'Prototipado Básico', 'Cómo conectar pantallas y crear interacciones.', 2, '2025-09-11 20:58:04', '2025-09-11 20:58:04'),
	(8, 5, 'Introducción a Pandas', 'Qué es Pandas y cómo cargar datos.', 1, '2025-09-11 20:58:04', '2025-09-11 20:58:04');

-- Volcando estructura para tabla academy_db.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('student','instructor','admin') DEFAULT 'student',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla academy_db.users: ~8 rows (aproximadamente)
INSERT INTO `users` (`id`, `name`, `email`, `password`, `role`, `created_at`, `updated_at`) VALUES
	(1, 'Ana López', 'ana@instructor.com', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', 'instructor', '2025-09-11 20:58:04', '2025-09-11 20:58:04'),
	(2, 'Carlos Ruiz', 'carlos@instructor.com', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', 'instructor', '2025-09-11 20:58:04', '2025-09-11 20:58:04'),
	(3, 'María Fernández', 'maria@instructor.com', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', 'instructor', '2025-09-11 20:58:04', '2025-09-11 20:58:04'),
	(4, 'Luis Pérez', 'luis@student.com', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', 'student', '2025-09-11 20:58:04', '2025-09-11 20:58:04'),
	(5, 'Sofía Gómez', 'sofia@student.com', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', 'student', '2025-09-11 20:58:04', '2025-09-11 20:58:04'),
	(6, 'Diego Mendoza', 'diego@student.com', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', 'student', '2025-09-11 20:58:04', '2025-09-11 20:58:04'),
	(7, 'Camila Torres', 'camila@student.com', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', 'student', '2025-09-11 20:58:04', '2025-09-11 20:58:04'),
	(8, 'Admin User', 'admin@academy.com', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', 'admin', '2025-09-11 20:58:04', '2025-09-11 20:58:04');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
