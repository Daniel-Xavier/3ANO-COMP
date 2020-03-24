% FATOS
% Predicado: comer(X,Y)
% Significado: X come Y 
come(urso,peixe).
come(peixe,alga).
come(urso,raposa).
come(cervo,grama).
% Predicado: animal(X)
% Significado: X é um animal
animal(urso).
animal(peixe).
animal(raposa).
animal(cervo).
planta(grama).
% REGRAS
% Regra: presa(X)
% Significado: para todo X e Y, X é uma presa se Y é
% tal que Y come X e X é um animal.   
presa(X):-come(_,X),animal(X).
% Regra: na_cadeia_alimentar(X,Y)
% Significado: para todo X, Y e Z, X e Y fazem parte de uma cadeia
% se X come Y ou se X come Z e Z e Y fazem parte da cadeia.
na_cadeia_alimentar(X,Y):-come(X,Y).
na_cadeia_alimentar(X,Y):-come(X,Z),na_cadeia_alimentar(Z,Y).