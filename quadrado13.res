Parametros basicos 
  Numero de pontos do contorno:          12
  Numero de pontos do dominio:            1
  Numero total de pontos:                13
  M�dulo de Elasticidade:               0.50E+04
  Coeficiente de Poisson:                   0.30
  Pontos de Gauss:                       10
  Tipo da funcao peso:                    2
     1-Gaussiana simples              
     2-Gaussiana com raio             
     3-Spline                         
  Estado Plano de:                        1
     1-Tens�o                         
     2-Deforma��o              


Dados dos pontos do contorno
 Ponto         Coordenadas X e Y        Componentes da normal      �ngulos iniciais e finais (rad)
     1          0.10        0.00          0.00       -1.00          0.00        3.14
     2          1.50        0.00          0.00       -1.00          0.00        3.14
     3          2.90        0.00          0.00       -1.00          0.00        3.14
     4          3.00        0.10          1.00        0.00          1.57        4.71
     5          3.00        1.50          1.00        0.00          1.57        4.71
     6          3.00        2.90          1.00        0.00          1.57        4.71
     7          2.90        3.00          0.00        1.00          3.14        6.28
     8          1.50        3.00          0.00        1.00          3.14        6.28
     9          0.10        3.00          0.00        1.00          3.14        6.28
    10          0.00        2.90         -1.00        0.00         -1.57        1.57
    11          0.00        1.50         -1.00        0.00         -1.57        1.57
    12          0.00        0.10         -1.00        0.00         -1.57        1.57


Dados dos pontos do contorno
 Ponto     Cond. Cont. (FP=0; DP=1)      X         Y
     1            0      0              0.33      0.00
     2            0      0              5.00      0.00
     3            0      0              9.67      0.00
     4            0      0              0.33    -10.00
     5            0      0              5.00    -10.00
     6            0      0              9.67    -10.00
     7            0      0             -9.67     10.00
     8            0      0             -5.00     10.00
     9            0      0             -0.33     10.00
    10            1      0              0.00      0.00
    11            1      0              0.00      0.00
    12            1      1              0.00      0.00


Coordenadas dos pontos do dominio
 Ponto        Coordenadas X e Y         fonte X fonte Y
   13           1.50      1.50           0.00      0.00


Informacoes sobre os pontos base
 Tipos da base (1: linear, 2: quadratica, 3: cubica)
 Ponto       Tipo       m         n         raio
    1         2         6         6         2.8001
    2         2         6         6         1.5400
    3         2         6         6         2.8001
    4         2         6         6         2.8001
    5         2         6         6         1.5400
    6         2         6         6         2.8001
    7         2         6         6         2.8001
    8         2         6         6         1.5400
    9         2         6         6         2.8001
   10         2         6         6         2.8001
   11         2         6         6         1.5400
   12         2         6         6         2.8001
   13         2         6        13         2.1000

 Ponto     Pontos selecionados dentro do suporte
    1         1    2    3   11   12   13
    2         1    2    3    4   12   13
    3         1    2    3    4    5   13
    4         2    3    4    5    6   13
    5         3    4    5    6    7   13
    6         4    5    6    7    8   13
    7         5    6    7    8    9   13
    8         6    7    8    9   10   13
    9         7    8    9   10   11   13
   10         8    9   10   11   12   13
   11         1    9   10   11   12   13
   12         1    2   10   11   12   13
   13         1    2    3    4    5    6    7    8    9   10   11   12   13


Resultados
 Ponto            Coordenadas X e Y               Desl. X          Desl. Y 
     1         0.10000           0.0000         -0.30362E-10     -0.13333E-04
     2          1.5000           0.0000          0.18222E-08     -0.24773E-02
     3          2.9000           0.0000          0.36747E-08     -0.92533E-02
     4          3.0000          0.10000          0.14000E-03     -0.99000E-02
     5          3.0000           1.5000          0.21000E-02     -0.93773E-02
     6          3.0000           2.9000          0.40600E-02     -0.79400E-02
     7          2.9000           3.0000          0.40600E-02     -0.71533E-02
     8          1.5000           3.0000          0.21000E-02     -0.37733E-03
     9         0.10000           3.0000          0.14000E-03      0.20867E-02
    10          0.0000           2.9000          0.92060E-36      0.19600E-02
    11          0.0000           1.5000          0.36671E-36      0.52267E-03
    12          0.0000          0.10000         -0.22286E-36     -0.11334E-36
    13          1.5000           1.5000          0.10500E-02     -0.19523E-02


 Ponto            Tens�o x         Tens�o y        Tens�o xy
     1              0.0000          -0.0000          -0.3333
     2              0.0000           0.0000          -5.0000
     3              0.0000          -0.0000          -9.6667
     4              0.3333           0.3333         -10.0000
     5              5.0000           5.0000         -10.0000
     6              9.6667           9.6667         -10.0000
     7             10.0000          10.0000          -9.6667
     8             10.0000          10.0000          -5.0000
     9             10.0000          10.0000          -0.3333
    10              9.6667           9.6667          -0.0000
    11              5.0000           5.0000           0.0000
    12              0.3333           0.3333           0.0000
    13              5.0000           5.0000          -5.0000


 Ponto             For�a x          For�a y
     1              0.3333           0.0000
     2              5.0000          -0.0000
     3              9.6667           0.0000
     4              0.3333         -10.0000
     5              5.0000         -10.0000
     6              9.6667         -10.0000
     7             -9.6667          10.0000
     8             -5.0000          10.0000
     9             -0.3333          10.0000
    10             -9.6667           0.0000
    11             -5.0000          -0.0000
    12             -0.3333          -0.0000
