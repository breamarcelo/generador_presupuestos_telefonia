<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" encoding="UTF-8" indent="yes" omit-xml-declaration="yes" />

    <xsl:template match="/Presupuesto">
        <html>
            <head>
                <style>
                    body {
                    font-family: 'Arial', sans-serif;
                    margin: 40px;
                    }
                    table {
                    width: 100%;
                    border-collapse: collapse;
                    border: 1px solid black;
                    margin-bottom: 40px;
                    }
                    h3, h4 {
                        padding: 0;
                        margin: 0;
                    }
                    
                    img {
                        width:60px;
                        margin: 20px; 
                    }

                    .header-table {
                        width: auto;
                        border: none;
                    }
                    .demo {
                        white-space: pre-wrap;
                        padding: 0;
                        
                    }

                    th {
                        background-color: grey;
                        color: white;
                    }
                    .body-table tr:nth-child(even) {
                        background-color: lightgrey;
                    }
                    .total {
                        font-weight: bold;
                        text-align: right;
                        margin-right: 20px;
                    }
                    .body-table tr:last-child {
                        background-color: white;
                    }
                    .body-table tr:last-child>td {
                        border-top: 1px solid black;
                    }

                </style>
            </head>
            <body>
                <table class="header-table">
                    <tr>
                        <td rowspan="2">
                            <img src="masorange-logo.png" alt="Logo" />
                        </td>
                        <td>
                            <h3>Presupuesto</h3>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h4>Orange Empresas</h4>
                        </td>
                    </tr>
                </table>
                <table class="body-table">
                    <thead>
                        <tr>
                            <th width="15%">CANTIDAD</th>
                            <th width="70%">DESCRIPCIÓN</th>
                            <th width="15%">IMPORTE</th>
                        </tr>
                    </thead>
                    <tbody>
                        <xsl:for-each select="LineasPresupuesto/Linea">
                            <xsl:if test="position()!=last()">
                                <tr>
                                    <td style="text-align: center;">
                                        <xsl:value-of select="Cantidad" />
                                    </td>
                                    <td>
                                        <xsl:value-of select="Descripcion" />
                                    </td>
                                    <td style="text-align: right;">
                                        <xsl:value-of select="Importe" />
                                    </td>
                                </tr>
                            </xsl:if>
                        </xsl:for-each>
                        <tr class="total-row">
                            <td colspan="2" class="total">Total:</td>
                            <td style="text-align: right;">
                                <xsl:value-of select="Total" />
                            </td>
                        </tr>
                    </tbody>
                </table>
                <xsl:for-each select="LineasPresupuesto/Linea">
                    <xsl:if test="position()=last()">
                        <div class="demo">
                            <xsl:value-of select="Descripcion" />
                        </div>
                    </xsl:if>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>