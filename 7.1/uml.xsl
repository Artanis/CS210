<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <link rel="stylesheet" href="uml.css" type="text/css" media="screen" charset="utf-8" />
            </head>
            <body>
            <xsl:for-each select="uml/class">
                <div class="class">
                    <h3><xsl:value-of select="@name" /></h3>
                    <ul class="data">
                        <xsl:for-each select="field">
                            <li>
                                <xsl:attribute name="class">
                                    <xsl:value-of select='@access'/>
                                </xsl:attribute>
                                <xsl:value-of select="@name" />: <xsl:value-of select="@type" />
                            </li>
                        </xsl:for-each>
                    </ul>
                    <hr/>
                    <ul class="methods">
                        <xsl:for-each select="method">
                            <li>
                                <xsl:attribute name="class">
                                    <xsl:value-of select='@access'/>
                                </xsl:attribute>
                                <xsl:value-of select="@name"/>(
                                    <xsl:for-each select="arg">
                                        <xsl:value-of select="@name" />:<xsl:value-of select="@type" />,
                                    </xsl:for-each>
                                ): <xsl:value-of select="@type" />
                            </li>
                        </xsl:for-each>
                    </ul>
                </div>
            </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
