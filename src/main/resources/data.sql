# INSERT INTO profil(libelle) VALUE ('EMPLOYE');
# INSERT INTO profil(libelle) VALUE ('PARENT');
# INSERT INTO profil(libelle) VALUE ('ADMIN');
#
# INSERT INTO section (annee, email, nom)
# VALUES (
#   '2018',
#   'section1@gmail.com',
#   'PETIT'
# ),
#   (
#     '2018',
#     'section2@gmail.com',
#     'MOYEN'
#   ),
#   (
#     '2018',
#     'section2@gmail.com',
#     'GRAND'
#   );
#
# INSERT INTO info (nom, prenom) value('nourry','bernard');
# INSERT INTO info (nom, prenom) value('valuet','corine');
# INSERT INTO info (nom, prenom) value('nourry','elise');
#
# INSERT INTO enfant_info (date_de_naissance,allergie,biberon,maladie,id)
#   VALUE (
#   localtime(),
#  true,
#   true,
#   true,
#   (SELECT id from info where prenom = 'elise')
# );
#
# INSERT INTO user_info (adresse, email, tel_fixe, tel_mobile, tel_pro, ville, id)
#     VALUE (
#     'rue lilas',
#   'toto@aol.com',
#   '0612654897',
#   '0145236598',
#   '0493659874',
#   'vence',
#     (SELECT id FROM info WHERE prenom = 'bernard')
#
#
# );
#
# INSERT INTO user_info (matricule, email,tel_mobile,fonction, id)
#   VALUE (
#     'ERY838',
#   'coco06@aol.com',
#   '0612654897',
#   'assistante maternelle',
#   (SELECT id FROM info WHERE nom = 'valuet')
#
#
# );
#
# INSERT INTO utilisateur (username, mot_de_passe, id_profil, actif,id_info ,id_section)
#   VALUE (
#   'toto@aol.com',
#   '$2a$10$1SNSZHgDBvoKlZZUnL.xW.PQaFaNS0C7K4fnDQB0P/fxDp8/4HknC',
#   (SELECT id FROM profil WHERE libelle = 'PARENT'),
#   true,
#   (SELECT id FROM user_info WHERE email= 'toto@aol.com'),
#   (select id from section where nom = 'PETIT')
# );
#
# INSERT INTO utilisateur (username, mot_de_passe, id_profil, actif,id_info )
#   VALUE (
#   'ERY838',
#   '$2a$10$nJDW4zADyAu2F942ChZy6eWnhtluR67pFqyAe5RenqJkFJe5zScLC',
#   (SELECT id FROM profil WHERE libelle = 'EMPLOYE'),
#   true,
#   (SELECT id FROM user_info WHERE email= 'coco06@aol.com')
# );

# INSERT INTO enfant (id_enfant_info, id_section)
#     VALUE (
#   (SELECT id FROM info WHERE prenom = "elise"),
#   (SELECT id FROM  section WHERE nom = "PETIT")
# )

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `loupitchoun`
--

--
-- Déchargement des données de la table `enfant`
--


--
-- Déchargement des données de la table `enfant_info`
--


--
-- Déchargement des données de la table `info`
--

INSERT INTO `info` (`id`, `nom`, `prenom`) VALUES
  (1, 'nourry', 'bernard'),
  (2, 'valuet', 'corine'),
  (3, 'nourry', 'elise'),
  (4, 'Nourry', 'Jean'),
  (5, 'albert', 'vincent');


INSERT INTO `enfant_info` (`allergie`, `biberon`, `date_de_naissance`, `maladie`, `id`) VALUES
  (b'1', b'1', '2018-05-20 09:05:05', b'1', 3),
  (b'1', b'0', '2018-01-03 00:00:00', b'0', 4),
  (b'0', b'0', '2018-05-02 00:00:00', b'1', 5);

--
-- Déchargement des données de la table `profil`
--

INSERT INTO `profil` (`id`, `libelle`) VALUES
  (1, 'EMPLOYE'),
  (2, 'PARENT'),
  (3, 'ADMIN');

--
-- Déchargement des données de la table `section`
--

INSERT INTO `section` (`id`, `annee`, `email`, `nom`) VALUES
  (1, '2018', 'section1@gmail.com', 'PETIT'),
  (2, '2018', 'section2@gmail.com', 'MOYEN'),
  (3, '2018', 'section2@gmail.com', 'GRAND');

--
-- Déchargement des données de la table `user_info`
--

INSERT INTO `user_info` (`adresse`, `date_embauche`, `email`, `fonction`, `matricule`, `tel_fixe`, `tel_mobile`, `tel_pro`, `type_contrat`, `ville`, `id`) VALUES
  ('rue lilas', NULL, 'toto@aol.com', NULL, NULL, '0612654897', '0145236598', '0493659874', NULL, 'vence', 1),
  (NULL, NULL, 'coco06@aol.com', 'assistante maternelle', 'ERY838', NULL, '0612654897', NULL, NULL, NULL, 2);

--
-- Déchargement des données de la table `utilisateur`
--
INSERT INTO `enfant` (`id`, `created_date`, `id_enfant_info`, `id_section`) VALUES
  (1, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770e05000007e2051409070d0660b0c078, 4, 1),
  (2, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770e05000007e2051409072406516e8078, 5, 1);


INSERT INTO `utilisateur` (`id`, `actif`, `created_date`, `mot_de_passe`, `updated_date`, `username`, `id_info`, `id_profil`, `id_section`) VALUES
  (1, b'1', NULL, '$2a$10$1SNSZHgDBvoKlZZUnL.xW.PQaFaNS0C7K4fnDQB0P/fxDp8/4HknC', NULL, 'toto@aol.com', 1, 2, 1),
  (2, b'1', NULL, '$2a$10$dhkn/NKcittNphhCUDU8hOy.s8gBGEaGRQYNlQiX6xMNi6h1MHuYm', 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770e05000007e205140907340fbc520078, 'ERY838', 2, 1, 1);
COMMIT;








