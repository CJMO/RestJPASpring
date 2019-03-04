Servicio Rest.

Esta implementado en el Framework Spring MVC, para gestión de datos enviados desde el frontend.
La capa de acceso a datos se diseñó mediante JPA, usando objetos DAO para la abstacción de entidades.

Desplegar listado de aves:
http://localhost:8080/datos/aves/lista

Desplegar listado de aves por zona:
http://localhost:8080/datos/aves/lista_zona?nombre_comun=NOMBRE&nombre_cient=NOM_CIENT&zona=COD_ZONA

NOMBRE: Nombre común a buscar
NOM_CIENT: Nombre científico a buscar
COD_ZONA: Código de zona a filtrar, estará disponible mediante lista despelgable.

Peticiones para ingreso de aves:
http://localhost:8080/datos/aves/insertar?codigo=COD&nombre_comun=NOMBRE&nombre_cient=NOMBREC&codigo_pais=CODPAIS

COD: Código del ave
NOMBRE: Nombre común del ave
NOMBREC: Nombre científico del ave
COD_ZONA: Código de zona, estará disponible mediante lista despelgable
CODPAIS: código del país, para relacionar el ave

Actualizar datos de ave:
http://localhost:8080/datos/aves/editar?codigo=COD&nombre_comun=NOMBRE&nombre_cient=NOMBREC

COD: Código del ave a buscar (no se actualiza)
NOMBRE: Nuevo nombre común del ave
NOMBREC: Nuevo nombre científico del ave

Eliminar ave:
http://localhost:8080/datos/aves/eliminar?codigo=COD&codigo_pais=CODPAIS

COD: Código del ave a eliminar
CODPAIS: código del país, para eliminar además en tabla de aves por país

Listado de zonas:
http://localhost:8080/datos/zonas/lista

Retorna datos de zonas, para lista desplegable en la vista
