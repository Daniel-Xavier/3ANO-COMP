def expressao(vars):
    p,q = vars
    return 1 if (p or not q) else 0

def getValores():
    return [(1,1), (1,0), (0,1), (0,0)]


print('p\tq\tnot P and Q')
print('---------------------------')
for par in getValores():
    p,q = par
    print('%i\t%i\t%i' %(p,q,expressao(par)))
    
