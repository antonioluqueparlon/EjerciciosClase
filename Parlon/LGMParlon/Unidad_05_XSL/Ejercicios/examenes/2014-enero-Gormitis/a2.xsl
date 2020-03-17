<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="html" encoding="UTF-8"/>

  <xsl:template match="/gormitis">
    <html>
      <head>
        <title>Gormitis</title>
        <style>

          img{
          width:55px;
          }

          .fondoVerde {
          background= #43FF01;
          }

          thead td {
          background = #40c2f7;
          font: bold 100% sans-serif;
          }

        </style>
      </head>
      <body>
        <table border="1" width="90%">
          <thead>
            <td></td>
            <td>Gormiti</td>
            <td>Tribu</td>
          </thead>
          <tbody>
            <xsl:for-each select="gormiti">
              <tr>
                <xsl:if test="position() mod 2 = 1 ">
                  <xsl:attribute name="class">fondoVerde</xsl:attribute>
                </xsl:if>
                <td>
                  <xsl:value-of select="position()"/>
                </td>
                <td>
                  <img src="{.}"/>
                    
                  
                </td>
                <td>
                  <xsl:value-of select=" @tribu"/>
                </td>
              </tr>
          </xsl:for-each>
          </tbody>
        </table>
       </body>
     </html>
   </xsl:template>
 

</xsl:stylesheet>
