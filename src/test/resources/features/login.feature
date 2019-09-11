# language: es
# encoding: iso-8859-1
Característica: Inicio de sesión
  Yo como usuario con privilegios
  quiero poder iniciar sesión en mi aplicación
  para acceder a la pagina principal

  Esquema del escenario: : Inicio de sesión Exitoso
    Dado que estoy en la página de inicio de sesión
    Cuando ingreso los datos del <usuario>
    Entonces yo ingreso a la aplicación

    Ejemplos: 
      | usuario |
      |       2 |
