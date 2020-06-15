##### GRUPO - Erro404 #####
## Bruna Galastri Guedes - 18.00189-0
## Daniel Ughini Xavier  - 18.00022-3 
## Rodolfo Cochi Bezerra - 18.00202-0 
## Vítor Martin Simoni   - 18.00050-9


########## IMPORTS ##########
from pathlib import Path


########## FUNCTIONS ##########
## MENU - choosing an automaton and asking for the chain ####
def getInputs():
    global originalChain
    print('Escolha um automato:\n1 - Automato 1\n2 - Automato 2\n3 - Automato 3\n4 - Automato 4\n5 - Automato Reais\nOu digite "s" para sair.')
    usrAut = input("Digite sua opcao: ")
    if not usrAut == 's':
        absPath = getAbsPath('Automato {}'.format(usrAut))
        aut = getAut(absPath)
        print("Deseja digitar ou importar a cadeia?")
        usrChain = input("Digite sua opcao [d/i]: ")
        if usrChain == 'd':
            chain = input("Digite a cadeia, com cada elemento separado por  ',': ").split(',')
            originalChain = chain.copy()
        elif usrChain == 'i':
            numChain = int(input("Digite o numero da cadeia [1,2,3,4]: "))
            chain = getChain(absPath, numChain)
            originalChain = chain.copy()
        if usrAut == '5':
            originalChain = chain.copy()
            chain = convertIntToN(chain)
    else:
        aut = 's'
        chain = []
        originalChain = chain.copy()
    return (aut, chain)

# converting chain number to 'n'
def convertIntToN(lista):
    for i in range(len(lista)):
        try:
            int(lista[i])
        except:
            pass
        else:
            lista[i] = 'n'
    print(lista)
    return lista  
             
# Displays imported automaton as dictionary
def showAut(aut):
    print('aut :', aut)
    print('    states :', aut['states'])
    print('    iniState :', aut['iniState'])
    print('    finStates :', aut['finStates'])
    print('    values :', aut['values'])
    print('    deltas :', aut['deltas'])

# function that prints the chain
def showChain(chain):
    print('chain :', chain)

# Get absolute Path to directory containning the automatons
def getAbsPath(dir):
    absPath = str(Path(__file__).parent.parent) + "\\Txt\\" + dir + '\\'
    return absPath

# Import automaton from some .txt file as dictionary
def getAut(absPath):
    with open(absPath + 'automato.txt') as file:
        dictionary = eval(file.read())
        return dictionary
        
# Import chain from some .txt file as list
def getChain(absPath, num):
    with open(absPath + 'chain%i.txt' % num) as file:
        lista = eval(file.read())
        lista = [str(step) for step in lista]
        return lista

# Run the automaton with a given chain
def simulate(aut, chain):
    print('Current state (Cur)\tValue (Val)\tNext state(Nex)')
    print('Cur\tVal\tNex')
    print(19 * '-')
    output = ''
    curState = aut['iniState']
    accept = False
    while len(chain) > 0:
        value = chain.pop(0)
        interfaceText = '%i\t%s\t' %(curState, value)

        # validating value and current state
        if value not in aut['values']:
            chain.insert(0, value)
            output = 'ERRO: O valor %s nao pertence ao alfabeto do automato.' % value
            break
        if curState not in aut['states']:
            output = 'ERRO: O estado %i nao pertence ao conjunto de estados do automato.' % curState
            break

        # getting next state
        try:
            curState = aut['deltas'][(curState, value)]
        except:
            output = 'Nao foi possivel realizar a transicao do estado %i com o valor %s.' % (curState, value)
            break
        else:
            interfaceText += str(curState)
            print(interfaceText)
    
    # Checking chain validity
    if curState in aut['finStates'] and len(chain) == 0:
        accept = True
    if accept:
        output = 'A cadeia %s foi ACEITA pelo automato.' % originalChain
    else:
        output = 'A cadeia %s foi REJEITADA pelo automato.' % originalChain
    
    return output


########## MAIN ##########
originalChain = [] # used to save original chain values, to display at the end of simulate()
# Simulating do{}while();
while True:
    (aut, chain) = getInputs()
    if aut == 's':
        print('Fechando o programa')
        break
    else:
        print('Cadeia digitada:', chain)
        output = simulate(aut, chain.copy())
        print(output)
        input('Aperte ENTER para continuar')
    print('\n' + 19 * '*' + '\n')