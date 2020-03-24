function [T1,T2] = desempenho(vetor)
%Determina o tempo de execucao

%% Usando a estrutura for
tic;
start = tic;
M = length(vetor);
for k=1:M
    if vetor(k)>1
        aux1(k) = 1;
    else
        aux1(k) = 0;
    end
end
toc;
T1 = toc(start);

%% Usando o Kernel MatLab
tic;
start = tic;
aux2 = vetor>1;
toc;
T2 = toc(start);
