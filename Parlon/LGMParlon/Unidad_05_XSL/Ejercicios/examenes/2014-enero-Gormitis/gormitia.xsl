<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="html" encoding="UTF-8"/>

  <xsl:template match="/gormitis">
    <html>
      <head>
        <title>Gormitis</title>
        <style>
         img{
         
         }
         
         background {
         
         }
      
        </style>
      </head>
      <body>ANTONIO
        <table border="1" width="90%">
          <thead>
            <td></td>
            <td>Gormiti</td>
            <td>Tribu</td>
            <td></td>
          </thead>
          <tbody>
            <xsl:for-each select="gormiti">
              <tr>
            </tr>
        </xsl:for-each>
          </tbody>
        </table>
      </body>
    </html>
  </xsl:template>

  
  <!--
  
  -->

  
 </xsl:stylesheet>
