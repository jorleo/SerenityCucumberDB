# language: es
# encoding: iso-8859-1
Caracter�stica: Inicio de sesi�n
  Yo como usuario con privilegios
  quiero poder iniciar sesi�n en mi aplicaci�n
  para acceder a la pagina principal

  Esquema del escenario: : Inicio de sesi�n Exitoso
    Dado que estoy en la p�gina de inicio de sesi�n
    Cuando ingreso los datos del <usuario>
    Entonces yo ingreso a la aplicaci�n

    Ejemplos: 
      | usuario |
      |       2 |
