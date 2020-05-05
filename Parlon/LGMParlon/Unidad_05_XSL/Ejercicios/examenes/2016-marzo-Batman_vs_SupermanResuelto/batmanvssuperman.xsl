<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="html" encoding="UTF-8"/>

	<xsl:template match="/cine">
		<html>
		   <head>
		      <title>Cartelera Cines ArteOcho Antonio</title>
		      <xsl:call-template name="estilos"/>
		      
		   </head>
		   <body>
		   	<div style="width: 1000px; margin: 0 auto;">
		    <xsl:apply-templates select="titulo"/>
		    <p></p>
		    <xsl:apply-templates select="sesiones"/>
		    <p></p>
		    <h2>Otras Peliculas</h2>
		    <xsl:apply-templates select="cartelera/pelicula"/>
		      
		     </div>
		   </body>
		       
		</html>

	</xsl:template>
	
	<xsl:template match="titulo">
		   
		      <h1>ArteOcho Lucena</h1>
		      <h2>Antonio Jesús Luque Parlón :D</h2>
		      <img src="http://www.webdidacticarafaelmunoz.appspot.com/lmsgi/image/batmanvssumperman/Batman-Vs-Superman.jpg" width="500px"></img>
		      <h2><xsl:value-of select="@nombre"/></h2>
		      <h3>Estreno: <xsl:value-of select="@estreno"/></h3>
	</xsl:template>
		     	
	<xsl:template match="sesiones">
				
		<xsl:call-template name="sesionesCoronaVirus"></xsl:call-template>
		
		</xsl:template>
		
	
	<xsl:template name="sesionesCoronaVirus">
			 <table border="1px" width="100%">
      <xsl:for-each select="sesion">
        <tr>
          <xsl:if test="position() mod 2 = 1">
            <xsl:attribute name="class">fondo</xsl:attribute>
          </xsl:if>
          <td align="center"> Sesión: 
        <xsl:value-of select="@hora"/>
            <table border="1" align="center" >
              <xsl:call-template name="bucleForFila">
                <xsl:with-param name="i">1</xsl:with-param>
              </xsl:call-template>
            </table>
          </td>
        </tr>
      </xsl:for-each>
    </table>
  </xsl:template>
	
 <xsl:template name="celdaCine">
    <xsl:param name="x"/>
    <xsl:param name="y"/>
    <td>
      <img width="50px">
        <xsl:attribute name="src"><xsl:value-of select="/cine/imagenes/imagen[@id = 'libre']"/></xsl:attribute>
        <xsl:for-each select="ocupado">
            <xsl:if test="($x = @fila) and ($y= @asiento)">
                <xsl:attribute name="src"><xsl:value-of select="/cine/imagenes/imagen[@id = 'ocupado']"/></xsl:attribute>
            </xsl:if>
        </xsl:for-each> 
      </img>
      
    </td>
  </xsl:template>
	
	
	<xsl:template name="imagenesCartelera">
		<xsl:param name="id"/>
		<xsl:for-each select="/cine/imagenes/imagen">
			<xsl:if test="$id = @id">
			<img src="{.}"/>
			</xsl:if>
		</xsl:for-each>
		
	</xsl:template>
	
	 <xsl:template name="bucleForColumna">
    <xsl:param name="i"/>
    <xsl:param name="j"/>
    <xsl:if test="$j &lt;= 4">
      <xsl:call-template name="celdaCine">
        <xsl:with-param name="x">
          <xsl:value-of select="$j"/>
        </xsl:with-param>
        <xsl:with-param name="y">
          <xsl:value-of select="$i"/>
        </xsl:with-param>
      </xsl:call-template>
      <xsl:call-template name="bucleForColumna">
        <xsl:with-param name="i">
          <xsl:value-of select="$i"/>
        </xsl:with-param>
        <xsl:with-param name="j">
          <xsl:value-of select="$j + 1"/>
        </xsl:with-param>
      </xsl:call-template>
    </xsl:if>
  </xsl:template>

	
	 <xsl:template name="bucleForFila">
    <xsl:param name="i"/>
    <xsl:if test="$i &lt;= 4">
      <tr>
        <xsl:call-template name="bucleForColumna">
          <xsl:with-param name="i">
            <xsl:value-of select="$i"/>
          </xsl:with-param>
          <xsl:with-param name="j">1</xsl:with-param>
        </xsl:call-template>
      </tr>
      <xsl:call-template name="bucleForFila">
        <xsl:with-param name="i">
          <xsl:value-of select="$i + 1"/>
        </xsl:with-param>
      </xsl:call-template>
    </xsl:if>
  </xsl:template>	
	 

	
	<xsl:template match="cartelera/pelicula">
	<table border="1" width="50%">
	<tr>
	<td align="center" width="150px" ><xsl:call-template name="imagenesCartelera" >
	<xsl:with-param name="id"><xsl:value-of select="@id"/></xsl:with-param>
	</xsl:call-template>
	</td>
	<td>
	<xsl:value-of select="@nombre"/>
	</td>
	</tr>
	</table>
	</xsl:template>
	
	<xsl:template name="imagenPeliculas">
		<xsl:param name="id"/>
		<xsl:for-each select="/cine/imagenes/imagen">
			<xsl:if test="$id = @id">
				<img src="{.}"/>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>
	
	
	<xsl:template name="estilos">
	
      <style type="text/css">
      	body {
        font-family: Arial;
        font-size: 12px;
        }
        
        .tablaSitiosCine td {
        width:80px;
        height:80px;           	
        }
        .fondo{
		background: #dbf7ff;
		}
          
   		</style>
   		</xsl:template>
   		
</xsl:stylesheet>