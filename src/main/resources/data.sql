INSERT INTO profil(libelle) VALUE ('EMPLOYE');
INSERT INTO profil(libelle) VALUE ('PARENT');
INSERT INTO profil(libelle) VALUE ('ADMIN');

INSERT INTO utilisateur (username, mot_de_passe, id_profil, actif)
  VALUE (
  'toto',
  '$2a$10$1SNSZHgDBvoKlZZUnL.xW.PQaFaNS0C7K4fnDQB0P/fxDp8/4HknC',
  (SELECT id FROM profil WHERE libelle = 'ADMIN'),
  true
);



