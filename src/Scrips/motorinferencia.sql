-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-06-2023 a las 01:27:51
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `motorinferencia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `opciones`
--

CREATE TABLE `opciones` (
  `id` int(11) NOT NULL,
  `texto` varchar(255) DEFAULT NULL,
  `idPregunta` int(11) DEFAULT NULL,
  `idResultado` int(11) DEFAULT NULL,
  `puntos` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `opciones`
--

INSERT INTO `opciones` (`id`, `texto`, `idPregunta`, `idResultado`, `puntos`) VALUES
(1, 'Extrovertido/a y sociable. ', 1, 1, 4),
(2, 'Introvertido/a y reflexivo/a.', 1, 2, 3),
(3, 'Amigable y adaptable.', 1, 3, 2),
(4, 'Apasionado/a y creativo/a.', 1, 4, 1),
(5, 'Participar en eventos sociales y actividades animadas.', 2, 1, 4),
(6, 'Disfrutar de momentos tranquilos y de reflexión personal.', 2, 2, 3),
(7, 'Compartir momentos con amigos y seres queridos.', 2, 3, 2),
(8, 'Explorar nuevas experiencias y expresar tu creatividad.', 2, 4, 1),
(9, 'Me siento energizado/a y emocionado/a.', 3, 1, 4),
(10, 'Me siento más cómodo/a en espacios más tranquilos.', 3, 2, 3),
(11, 'Me adapto fácilmente y disfruto de la compañía de los demás.', 3, 3, 2),
(12, 'Me inspira y motiva la interacción con diferentes personas.', 3, 4, 1),
(13, 'Divertirme y disfrutar del momento. ', 4, 1, 4),
(14, 'Establecer conexiones profundas y significativas.', 4, 2, 3),
(15, 'Brindar apoyo y estar presente para los demás.', 4, 3, 2),
(16, 'Estimular la creatividad y el crecimiento mutuo.', 4, 4, 1),
(17, 'Soy muy extrovertido y todos me conocen.', 5, 5, 5),
(18, 'Soy ambivertido, disfruto pasar el rato con los demás, pero también necesito mi tiempo a solas.', 5, 6, 4),
(19, 'Soy introvertido, pero una vez que me conocen bien, me convierto en un gran amigo.', 5, 7, 3),
(20, 'Soy extrovertido y siempre estoy listo para la fiesta.', 5, 8, 2),
(21, 'Soy extrovertido y el alma de la fiesta, me llevo bien con todos.', 5, 9, 1),
(22, 'Las sigo cuidadosamente y las considero muy importantes.', 6, 5, 5),
(23, 'Tengo un enfoque más liberal y no me importa desafiar algunas normas conservadoras.', 6, 6, 4),
(24, 'Las respeto, pero también cuestiono y desafío algunas de ellas.', 6, 7, 3),
(25, 'Soy conservador pero siempre respeto a los demás.', 6, 8, 2),
(26, 'Tiendo a salir fuera de las normas y leyes, pero soy una buena persona y eso es lo que importa.', 6, 9, 1),
(27, 'Vengo de una familia conservadora y tengo una relación cercana con ellos.', 7, 5, 5),
(28, 'Mi familia es conservadora, pero yo soy más liberal y tengo mis propias ideas.', 7, 6, 4),
(29, 'Tengo una relación cercana con mi familia, pero también tengo mis propias opiniones.', 7, 7, 3),
(30, 'Mi familia es primero y siempre busco que estén bien. ', 7, 8, 2),
(31, 'Tengo una buena relación con mi familia y me llevo bien con todos.', 7, 9, 1),
(32, 'Es muy importante para mí ser aceptado y reconocido socialmente.', 8, 5, 5),
(33, 'No es mi principal preocupación, pero valoro las relaciones sociales.', 8, 6, 4),
(34, 'No me preocupa mucho, prefiero tener unos pocos amigos verdaderos.', 8, 7, 3),
(35, 'Me importa más disfrutar del momento y divertirme con los demás.', 8, 8, 2),
(36, 'Me importa ser aceptado y disfruto de la compañía de todos.', 8, 9, 1),
(37, 'Prefiero seguir lo que conozco y me siento cómodo/a.', 9, 5, 5),
(38, 'Estoy dispuesto/a a probar cosas nuevas, pero dentro de ciertos límites.', 9, 6, 4),
(39, 'Estoy dispuesto/a a probar cosas nuevas y desafiar mis propios límites.', 9, 7, 3),
(40, 'Siempre estoy abierto/a a nuevas experiencias y no tengo miedo de salir de mi zona de confort.', 9, 8, 2),
(41, 'Tengo gustos extraños y estoy dispuesto/a a probar cosas nuevas sin importar lo que piensen los demás.', 9, 9, 1),
(42, 'IDE (Entorno de Desarrollo Integrado)', 10, 10, 4),
(43, 'Editor de texto simple', 10, 11, 3),
(44, 'Línea de comandos', 10, 12, 2),
(45, 'No tengo preferencia clara', 10, 13, 1),
(46, 'Me encanta colaborar y compartir conocimientos', 11, 10, 4),
(47, 'Prefiero trabajar de forma individual, pero puedo adaptarme si es necesario', 11, 11, 3),
(48, 'Me siento más cómodo trabajando solo', 11, 12, 2),
(49, 'Depende del proyecto y el equipo en particular', 11, 13, 1),
(50, 'Me gusta investigar y encontrar soluciones innovadoras', 12, 10, 4),
(51, 'Me gusta seguir una metodología estructurada para resolverlos', 12, 11, 3),
(52, 'Me frustra, pero persisto hasta encontrar una solución', 12, 12, 2),
(53, 'Prefiero evitar los problemas complicados y centrarme en tareas más sencillas', 12, 13, 1),
(54, 'Aprendo mejor a través de la lectura y la documentación', 13, 10, 4),
(55, 'Me gusta aprender a través de tutoriales y ejemplos prácticos', 13, 11, 3),
(56, 'Aprendo mejor experimentando y resolviendo problemas por mi cuenta', 13, 12, 2),
(57, 'Me adapto a diferentes estilos de aprendizaje', 13, 13, 1),
(58, 'Me motiva a trabajar más eficientemente', 14, 10, 4),
(59, 'Me pone algo nervioso, pero puedo manejarlo', 14, 11, 3),
(60, 'Me estresa y afecta mi rendimiento', 14, 12, 2),
(61, 'No me preocupa mucho, puedo trabajar a mi propio ritmo', 14, 13, 1),
(62, 'Desarrollo web o aplicaciones móviles', 15, 10, 4),
(63, 'Programación de sistemas o infraestructura', 15, 11, 3),
(64, 'Análisis de datos o inteligencia artificial', 15, 12, 2),
(65, 'No tengo una preferencia clara', 15, 13, 1),
(66, 'Diseñar y crear experiencias de usuario intuitivas', 16, 10, 4),
(67, 'Optimizar el rendimiento y la eficiencia del código', 16, 11, 3),
(68, 'Resolver problemas complejos y crear algoritmos eficientes', 16, 12, 2),
(69, 'Realizar tareas de programación según lo requerido', 16, 13, 1),
(70, 'Me emociona y disfruto explorar nuevos lenguajes', 17, 10, 4),
(71, 'Estoy dispuesto a aprender si es necesario, pero prefiero dominar uno o dos', 17, 11, 3),
(72, 'Me siento abrumado y me cuesta adaptarme a nuevos lenguajes', 17, 12, 2),
(73, 'No tengo una preferencia clara', 17, 13, 1),
(74, 'Me gusta analizar y rastrear el problema paso a paso', 18, 10, 4),
(75, 'Utilizo herramientas de depuración para identificar y solucionar errores', 18, 11, 3),
(76, 'Pruebo diferentes soluciones hasta que el código funcione correctamente', 18, 12, 2),
(77, 'Evito tareas de depuración y busco ayuda externa', 18, 13, 1),
(78, 'Leo blogs y artículos técnicos regularmente', 19, 10, 4),
(79, 'Participo en comunidades en línea y foros de discusión', 19, 11, 3),
(80, 'Experimento con nuevas tecnologías por mi cuenta', 19, 12, 2),
(81, 'No me preocupo mucho por las últimas tendencias', 19, 13, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE `preguntas` (
  `id` int(11) NOT NULL,
  `enunciado` varchar(255) DEFAULT NULL,
  `idQuiz` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `preguntas`
--

INSERT INTO `preguntas` (`id`, `enunciado`, `idQuiz`) VALUES
(1, '¿Cómo te defines en términos de personalidad? ', 1),
(2, '¿Qué tipo de actividades disfrutas más en tu tiempo libre? ', 1),
(3, '¿Cómo te sientes en ambientes con mucha gente? ', 1),
(4, '¿Cuál es tu enfoque principal en tus relaciones personales? ', 1),
(5, '¿Cómo te describirías en términos de sociabilidad? ', 2),
(6, '¿Qué opinas acerca de las normas y las leyes? ', 2),
(7, '¿Cómo es tu relación con la familia? ', 2),
(8, '¿Qué tan importante es para ti ser aceptado por los demás? ', 2),
(9, '¿Qué tan dispuesto/a estás a desafiarte a ti mismo/a y probar cosas nuevas? ', 2),
(10, '¿Cuál es tu entorno de programación preferido?', 3),
(11, '¿Cómo te sientes acerca de trabajar en equipo?', 3),
(12, '¿Cómo te enfrentas a los problemas de programación difíciles?', 3),
(13, '¿Cuál es tu estilo de aprendizaje preferido?', 3),
(14, '¿Cómo te sientes acerca de los plazos ajustados?', 3),
(15, '¿Qué tipo de proyectos te interesan más?', 3),
(16, '¿Cuál es tu enfoque principal al programar?', 3),
(17, '¿Cómo te sientes acerca de aprender nuevos lenguajes de programación?', 3),
(18, '¿Cuál es tu enfoque al depurar código con errores?', 3),
(19, '¿Cómo te mantienes actualizado sobre las últimas tendencias en programación?', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `quizzes`
--

CREATE TABLE `quizzes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `quizzes`
--

INSERT INTO `quizzes` (`id`, `nombre`) VALUES
(1, '¿Que tipo de tamal eres?'),
(2, '¿Que tipo de tortilla eres?'),
(3, '¿Que tipo de programador eres?');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resultados`
--

CREATE TABLE `resultados` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `idQuiz` int(11) DEFAULT NULL,
  `descripcion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `resultados`
--

INSERT INTO `resultados` (`id`, `nombre`, `idQuiz`, `descripcion`) VALUES
(1, 'Tamal de carne', 1, 'Eres extrovertido/a, sociable y disfrutas de la compañía de los demás. Te gusta estar en eventos sociales y agregar energía a los ambientes.'),
(2, 'Tamal de queso', 1, 'Eres introvertido/a, reflexivo/a y valoras los momentos de tranquilidad. Prefieres la compañía selecta y aprecias la calma en tus relaciones personales.'),
(3, 'Tamal de pollo', 1, 'Eres amigable, adaptable y disfrutas de la compañía de amigos y seres queridos. Te preocupas por el apoyo mutuo y la conexión emocional en tus relaciones.'),
(4, 'Tamal de verduras', 1, 'Eres apasionado/a, creativo/a y te gusta explorar nuevas experiencias. Disfrutas de la interacción con personas diversas y valoras el crecimiento personal.'),
(5, 'Tortilla de maiz', 2, 'Persona extrovertida, que todos conocen y que no puede faltar en un grupo de amistades, tiene buen salario y es medio fresa (que pertenece a una clase social privilegiada, generalmente de dinero y que no se arriesga a contravenir normas y leyes ), de familia conservadora.'),
(6, 'Tortilla de maiz amarilla', 2, 'Es introvertido, se disfruta pasar el tiempo con esa persona, aunque su familia es conservadora el es muy liberal.'),
(7, 'Tortilla de harina', 2, 'Es introvertido, es al que muchos conocen pero lo tienen mal juzgado, pero cuando lo conocen bien se vuelve tu mejor amigo.'),
(8, 'Tortilla de harina sobaquera', 2, 'Es extrovertido, norteño de corazon y siempre es el que lleva cerveza o cosas para la fiesta, liberal y se lleva mal con la tortilla de maiz.'),
(9, 'Tortilla de harina para taco', 2, 'Es extrovertido, el alma de la fiesta y se lleva bien con todos, es el que tiene gustos extraños pero que nadie puede juzgar por lo buena persona que es.'),
(10, 'Programador Orientado a la Experiencia de Usuario', 3, 'Disfrutas diseñando interfaces intuitivas y creando experiencias agradables para los usuarios'),
(11, 'Programador Orientado al Rendimiento', 3, 'Te enfocas en optimizar el rendimiento y la eficiencia del código para lograr un mejor rendimiento del sistema.'),
(12, 'Programador Orientado a la Resolución de Problemas', 3, 'Disfrutas resolver problemas complejos y crear algoritmos eficientes.'),
(13, 'Programador Versátil', 3, 'No tienes una preferencia clara y te adaptas a diferentes proyectos y enfoques de programación.');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `opciones`
--
ALTER TABLE `opciones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idPregunta` (`idPregunta`),
  ADD KEY `idResultado` (`idResultado`);

--
-- Indices de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idQuiz` (`idQuiz`);

--
-- Indices de la tabla `quizzes`
--
ALTER TABLE `quizzes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `resultados`
--
ALTER TABLE `resultados`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idQuiz` (`idQuiz`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `opciones`
--
ALTER TABLE `opciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=88;

--
-- AUTO_INCREMENT de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `quizzes`
--
ALTER TABLE `quizzes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `resultados`
--
ALTER TABLE `resultados`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `opciones`
--
ALTER TABLE `opciones`
  ADD CONSTRAINT `opciones_ibfk_1` FOREIGN KEY (`idPregunta`) REFERENCES `preguntas` (`id`),
  ADD CONSTRAINT `opciones_ibfk_2` FOREIGN KEY (`idResultado`) REFERENCES `resultados` (`id`);

--
-- Filtros para la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD CONSTRAINT `preguntas_ibfk_1` FOREIGN KEY (`idQuiz`) REFERENCES `quizzes` (`id`);

--
-- Filtros para la tabla `resultados`
--
ALTER TABLE `resultados`
  ADD CONSTRAINT `resultados_ibfk_1` FOREIGN KEY (`idQuiz`) REFERENCES `quizzes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
