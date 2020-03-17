<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="html" encoding="UTF-8"/>

  <xsl:template match="/juegoTanques">
    <html>
      <head>
        <title>Juego de Tanques</title>
        <style>

          img{
          width:55px;
          }

          .fondoVerde {
          background= #43FF01;
          }

          thead td {
          background = #010BFF;
          color: #FFFFFF;
          font: bold 100% sans-serif;
          }

          table img {
          width: 50px;
          }

        </style>
      </head>
      <body>
        <table border="1" width="90%">
          <thead>
            <td></td>
            <td>Jugada</td>
            <td>Tanque</td>
            <td>Descripción</td>
            
          </thead>
          <tbody>
            <xsl:for-each select="jugadasDescritas/jugada">
              <xsl:choose>
                <xsl:when test="position() mod 2 = 1">
                  <xsl:call-template name="pintaFila">
                    <xsl:with-param name="color">#01FFB0</xsl:with-param>
                    <xsl:with-param name="numeroJugador">
                      <xsl:value-of select="@jugador"/>
                    </xsl:with-param>
                  </xsl:call-template>
                </xsl:when>
                <xsl:otherwise>
                  <xsl:call-template name="pintaFila">
                    <xsl:with-param name="color">#ffffff</xsl:with-param>
                    <xsl:with-param name="numeroJugador">
                      <xsl:value-of select="@jugador"/>
                    </xsl:with-param>
                  </xsl:call-template>
                </xsl:otherwise>
              </xsl:choose>
            </xsl:for-each>
          </tbody>
        </table>
      </body>
    </html>
  </xsl:template>


  <xsl:template name="pintaFila">
    <xsl:param name="color"></xsl:param>
    <xsl:param name="numeroJugador"></xsl:param>

    <tr style="background: {$color}">
      <td>
        <xsl:value-of select="position()"/>
      </td>
      <td>
        <xsl:value-of select="@jugador"/>
      </td>
      <td>
        <img src="{/juegoTanques/tanques/imagenTanque[@jugador=$numeroJugador]}"/>
      </td>
      <td>
        <xsl:value-of select="@desc"/>
      </td>

    </tr>
    
    
    
    
  </xsl:template>

</xsl:stylesheet>


