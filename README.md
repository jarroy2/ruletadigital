# ruletadigital
12318 Digital Roulette

John is developing a videogame that allows players to bet in a wall roulette. Players may bet for integer
numbers from 0 to N, for some N >= 0 that represents the maximum number in the roulette.
Of course, the roulette behaves digitally. As a matter of fact, John designed its way to choose a
value in the interval 0::N (the result of spinning the roulette) with a digital trigger that moves the
roulette with a force that depends on an integer value x randomly chosen in the interval 0::M, where
M >= 0 (M is the maximal appliable force). The roulette turns around a distance equivalent to P(x),
where P is a polynomial with integer coefficients. One distance unit represents a displacement of one
roulette number, counting clockwise.
It is clear that some result values may be produced by different chosen force values. Also, depending
on the mechanism parameters, some numbers in the roulette may be not attainable regardless of the
force value. For example, if N = 7, M = 5 and P(x) = x2 + 1, the mechanism can generate only three
different results:
