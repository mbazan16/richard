

INSERT INTO users (username, password, enabled)
  values ('user1',
    '$2y$04$Wa8i//c3zj7GFf3s.cGLluzIHd.6b..OGmPjYk1Jm7ABkov3Pqzai',
    1);
INSERT INTO users (username, password, enabled)
  values ('admin',
    '$2y$04$dPiNvrHA/qzT0um0mIJxJeDK4oolZtXu18PAgQtksFDfeIVdrTLX6',
    1);
 
INSERT INTO authorities (username, authority)
  values ('user1', 'ROLE_USER');
INSERT INTO authorities (username, authority)
  values ('admin', 'ROLE_ADMIN');
  
