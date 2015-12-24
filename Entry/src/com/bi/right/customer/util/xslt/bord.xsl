<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : bord.xsl
    Created on : 27 octobre 2013, 20:10
    Author     : tiaray
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:output>----------------Bordereau de la liste des pièces-------------</xsl:output>
<xsl:template match="/">
<xsl:for-each select="pieces/list">
PIECE(S) numero <xsl:value-of select="numero"/>...<xsl:value-of select="label"/>
</xsl:for-each>
</xsl:template>
<xsl:output>----------------Plaise au conseil-----------------------------</xsl:output>
</xsl:stylesheet>
