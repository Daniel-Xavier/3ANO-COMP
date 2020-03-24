%Fatos sobre populações de países (milhões de habitantes)
populacao( eua, 318) .
populacao( brasil, 2 00) .
populacao( china, 1357) .
populacao( india, 1252) .
%Fatos sobre áreas de países (milhões de km2)
area( eua, 9.8) .
area( brasil, 8.5) .
area( china, 9.5) .
area( india, 3.3) .
%Regra para densidade
densidade( X , Y ):-
    populacao( X , P ),
    area( X , A ),
    Y is P / A.
    
