% X pertence à L se X é cabeça da lista L
member( X ,[X | _ ]).

% Ou se X pertence à cauda da lista L
member( X ,[_ | Tail]):-
    member( X , Tail) .
% Uma lista vazia concatenada com uma lista L resulta em L
conc([],L , L ) .

% Uma lista L que possua X como cabeça concatenada com outra
% resulta em uma lista concatenada com X como cabeça 
conc([X | L1],L2,[X | L3]):-
    conc( L1, L2, L3) .

% X é um elemento que adicionado à frente da lista L 
% resulta na lista [X|L]
add( X , L , [X | L ]).

% Se X é a cabeça de uma lista, então o resultado de remover
% X desta lista é sua cauda.
del( X ,[X | Tail],Tail) .

% Se X estiver na cauda, então ele deve ser eliminado de lá.
del( X ,[Head| Tail],[Head| TailWithoutX]):-
    del( X , Tail, TailWithoutX) .

% Dizer que inserir X à uma lista torna-a maior é o mesmo que
% dizer que remover X da lista maior resulta na lista original.
insert( X , List, BiggerList):-
    del( X , BiggerList, List) .
