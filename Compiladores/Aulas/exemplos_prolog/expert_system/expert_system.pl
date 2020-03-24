:-op( 8 00, fx, if) .
:-op( 7 00, xfx, then) .
:-op( 3 00, xfy, or) .
:-op( 2 00, xfy, and) .
is_true( P ):-
fact( P ) .
is_true( P ):-
if Condition then P ,
    is_true( Condition).
is_true( P1 and P2):-
    is_true( P1 ),
    is_true( P2 ).
is_true( P1 or P2 ):-
    is_true( P1 );
    is_true( P2 ).

if hall_wet and kitchen_dry then
    leak_in_bathroom.

if hall_wet and bathroom_dry then
    problem_in_kitchen.

if window_closed or no_rain then
    no_water_from_outside.

forward :-
    new_derived_fact( P ), 
    ! ,
    write( 'Derived: '), write( P ), nl,
    fact( P ),
    forward
    ;
    write( 'No more facts') .

new_derived_fact( Concl):-
    if Cond then Concl, 
    \+fact( Concl),
    composed_fact(Cond).

composed_fact( Cond):-
    fact(Cond).

composed_fact(Cond1 and Cond2):-
    composed_fact( Cond1),
    composed_fact( Cond2).

composed_fact( Cond1 or Cond2):-
    composed_fact( Cond1);
    composed_fact( Cond2) .

% Some facts...
fact( hall_wet) .
fact( window_closed) .
fact( bathroom_dry) .
% Execute: ?- forward.
