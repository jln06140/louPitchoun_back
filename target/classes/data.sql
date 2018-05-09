INSERT INTO profil(libelle) VALUE ('EMPLOYE');
INSERT INTO profil(libelle) VALUE ('PARENT');
INSERT INTO profil(libelle) VALUE ('ADMIN');

INSERT INTO info (nom, prenom) value('nourry','bernard');

INSERT INTO user_info (adresse, email, tel_fixe, tel_mobile, tel_pro, ville, id)
    VALUE (
    'rue lilas',
  'toto@aol.com',
  '0612654897',
  '0145236598',
  '0493659874',
  'vence',
    (SELECT id FROM info WHERE nom = 'nourry')


);

INSERT INTO utilisateur (username, mot_de_passe, id_profil, actif,id_info )
  VALUE (
  'toto',
  '$2a$10$1SNSZHgDBvoKlZZUnL.xW.PQaFaNS0C7K4fnDQB0P/fxDp8/4HknC',
  (SELECT id FROM profil WHERE libelle = 'PARENT'),
  true,
  (SELECT id FROM user_info WHERE email= 'toto@aol.com')
);



