%% Vitor Martin Simoni - 18.00050-9

%% Limpando Ambiente
clear all;
clc;
close all;
pkg load symbolic;


%% Definindo sinal
g1 = @(t) (t+1);
g2 = @(t) (-t+1);


%% Calculando as integrais simbolicas
syms n t T0 T1 T2 w

Pg = 1/T0 * (int((t+1)^2, t, T1, 0) + int((1-t)^2, t, 0, T2));

Dn = 1/T0 * (int(g1 .* exp(-j*w*n*t), t, T1, 0) + int(g2 .*exp(-j*n*w*t), t, 0, T2));
D0 = 1/T0 * (int(g1, t, T1, 0) + int(g2, t, 0, T2));


%% Avaliando integrais
T0 = 2;
T1 = -1;
T2 = 1;
w = 2*pi/T0; % --> w0
R = 1000; % resolucao
tempo  = [-1: abs(T0/R) : 1];
tempo1 = [-1: abs(T1/R) : 0];
tempo2 = [0 : abs(T2/R) : 1];

Pg = eval(Pg);
Py = .95 * Pg;


%% Definindo qtde de harmonicas para satisfazer Py
PotAcumulada = abs(eval(D0))^2; % Potencia de D0
n = 1;
while PotAcumulada < Py
	H  = abs(eval(Dn)); % H --> Harmonica
	PN = 2 * H^2; % Potencia parcial de Dn e D-n
	
	n++;
	PotAcumulada += PN; % Soma das potencias parciais
end
n--;
if n == 0
  n = 1; % Nao faz sentido n=0, mesmo que satisfaca a condicao de potencia
end
N = n;
n = [-N:1:N];


%% Avaliando Dn com qtde de harmonicas encontradas
D0 = eval(D0);
Dn = eval(Dn);
Dn(N+1) = D0;


%% Sintetizando o sinal
aux  = 0;
for k = 0 : 2*N
  aux += Dn(k+1)*exp(j*n(k+1)*w*tempo);
end
gy = aux;


%% Graficos
f0 = 1/T0;
f = n/T0;

% Grafico do sinal original g(t)
figure(1);
plot(tempo1, g1(tempo1), tempo2, g2(tempo2));
grid;
title("Sinal original: g(t)");
xlabel("tempo [s]");
ylabel("Amplitude [V]");

% Grafico da decomposicao das harmonicas Dn
figure(2);
stem(f, abs(Dn));
grid;

% Grafico da sintetizacao do sinal
figure(3)
plot(tempo,gy);
grid;

%% Resposta
% A banda B deve possuir N Hertz
resolucao = PotAcumulada / Pg;
disp(cstrcat("A banda B deve possuir ", num2str(N), "Hz, com ",
             num2str(resolucao * 100), "% de resolucao."));

