% FATOS
% Predicado: come(X,Y).
% Significado: X come Y
come(urso, peixe).
come(urso, raposa).
come(cervo, grama).
come(peixe, alga).

% Predicado: animal(X).
% Significado: X é um animal
animal(urso).
animal(peixe).
animal(raposa).
animal(cervo).
planta(grama).
planta(alga).

% RECURSIVIDADE
na_cadeia_alimentar(X,Y):-come(X,Y).
na_cadeia_alimentar(X,Y):-
    come(X,Z), na_cadeia_alimentar(Z,Y).
presa(X):-
    come(_,X), animal(X).
