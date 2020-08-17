import math

def f(n):
    i=4
    m=0
    while(i<=n):
        m+=1
        i+=2
    return m

def m1(n):
    return math.floor((n-1)/2)

def m3(n):
    return math.ceil((n-3)/2)

header = "n    f(n)     n-1     n-3"
print(header)
print(len(header)*'-')
for n in range(4, 100):
    print("%i\t%i\t%i\t%i" %(n,f(n),m1(n),m3(n)))