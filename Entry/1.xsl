<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr">
<meta http-equiv="Content-Type" content="text/HTML; charset=utf-8" />
  <body style="font-size:11px;width:595px;height:841px;">
          <tbody>
    <table border="0" cellpadding="1" cellspacing="1">

        <tr>
          <td valign="top"><tr><h2>Reservé  au Greffe</h2></tr>
           <table border="1" width="100%" ><tr>Demande   </tr><tr><input type="checkbox"/> reçue </tr><tr><input type="checkbox"/> déposée le</tr>
           <tr></tr><tr>................................................</tr></table>
           <table border="1" width="100%" ><tr>R.G:</tr><tr>................................................</tr><tr></tr><tr></tr></table>
           <xsl:if test="guiManager/conseil/section = ''">
               <table border="1" width="100%" ><tr>SECTION:</tr><tr>................................................</tr><tr></tr><tr></tr></table>
            </xsl:if>
           <xsl:if test="guiManager/conseil/section != ''">
               <table border="1" width="100%" ><tr>SECTION:</tr><tr>......<xsl:value-of select="guiManager/conseil/section"/>.......................</tr><tr></tr><tr></tr></table>
            </xsl:if>
           <table border="1" width="100%" ><tr>CHAMBRE:</tr><tr>................................................</tr><tr></tr><tr></tr></table>
           <table border="1" width="100%" ><tr>FORMATION DE REFERE DU :</tr><tr>................................................</tr><tr></tr><tr></tr></table>
          
          </td>
          <td valign="top,left">Conseil
             
             <tr>
            <tr>
            <td>
            <xsl:for-each select="guiManager/conseil/addrid">
              <tr>
                <xsl:value-of select="adrline1"/>
              </tr>
              <tr>
                <xsl:value-of select="adrline2"/>
              </tr>
              <tr>                                    
                <xsl:value-of select="adrline3"/>
              </tr>
                <tr>
                  <xsl:value-of select="pstcd"/>
                </tr>
              <tr>
                <xsl:value-of select="twnnm"/>
              </tr>
              </xsl:for-each>
               </td><td><h3>Demande de saisine du conseil de Prud'Hommes</h3></td>
               </tr>
          <tr><tr><u><h2>Présenté par le Demandeur</h2></u></tr>
          
            <xsl:for-each select="guiManager/demandeur">
     <xsl:choose>
     <xsl:when test="salarie = 'true'">
     
     <tr><b><input type="radio" name="d"  value="1" checked="true" />Demandeur salarié</b>
     <b><input type="radio" name="d"  value="2"/> Demandeur société</b></tr>
     
      </xsl:when>
      <xsl:otherwise>
      
      <tr><b><input type="radio" name="d2"  value="1" />Demandeur salarié</b>
      <b> <input type="radio" name="d2"  value="2" checked="true"  /> Demandeur société</b></tr>
      
       </xsl:otherwise> 
    </xsl:choose>
    </xsl:for-each>
    
     <xsl:for-each select="guiManager/demandeur">
     <tr>
     <xsl:choose>
     <xsl:when test="personId/cadre = 'true'">
         <b><input type="radio" name="c"  value="1" checked="true" />Salarié Cadre</b><b><input type="radio" name="c"  value="2"/>Salarié Non Cadre</b>
    </xsl:when>
    <xsl:when test="personId/cadre = 'false'">
                  <b><input type="radio" name="c1"  value="1" checked="true" />Salarié Cadre</b><b><input type="radio" name="c1"  value="2"/>Salarié Non Cadre</b>
     </xsl:when>
      <xsl:otherwise>
      Inconnu
      </xsl:otherwise> 
    </xsl:choose>
    </tr>
     <tr><td>
     <tr><b>Nom</b>:<xsl:value-of select="personId/individu/nm"/></tr>
     <tr><b>Prénom</b>:<xsl:value-of select="personId/individu/pnm"/></tr>
     <tr><b>Nationalité</b>:<xsl:value-of select="nationalite"/></tr>
     <tr><b>Date de naissance</b>:<xsl:value-of select="personId/individu/birthdt"/></tr>
     <tr><b>Lieu de Naissance</b>:<xsl:value-of select="personId/individu/cityofbirth"/></tr>
     <tr><b>Téléphone</b>:<xsl:value-of select="personId/individu/tel/pnumber"/></tr>
     <tr><b>Profession</b>:<xsl:value-of select="pro"/></tr>
     </td><td>
     <tr><b>Adresse</b></tr>
      <tr><xsl:value-of select="personId/individu/addr/adrline1"/></tr>
      <tr><xsl:value-of select="personId/individu/addr/adrline2"/></tr>
      <tr><xsl:value-of select="personId/individu/addr/adrline3"/></tr>
      <tr><b>Code postal :</b><xsl:value-of select="personId/individu/addr/pstcd"/><b> Ville:</b> <xsl:value-of select="personId/individu/addr/twnnm"/></tr>
    </td>
    </tr>
    </xsl:for-each>
     
   
     <tr><b>Nature du Contrat</b></tr>
     <xsl:for-each select="guiManager/contrat">
     
     <tr><xsl:if test="ecrit = 'false'">
         
          Contrat non écrit
        
      </xsl:if>
     </tr>
     <tr><xsl:if test="cdi = 'true'">
        
          <input type="radio" name="cdx"  value="1" checked="true" />CDI
          <input type="radio" name="cdx"  value="2" />CDD
          <input type="radio" name="cdx"  value="3" />Autre <xsl:value-of select="nature"/>

        
      </xsl:if>
      <xsl:if test="cdd = 'true'">
        
          <input type="radio" name="cdx"  value="1" checked="true" />CDD
          <input type="radio" name="cdx"  value="2" />CDD
          <input type="radio" name="cdx"  value="3" />Autre <xsl:value-of select="nature"/>

        
      </xsl:if>
      <xsl:if test="cdi = 'false'">
        <xsl:if test="cdd = 'false'">
        
          <input type="radio" name="cdx"  value="1" />CDI
          <input type="radio" name="cdx"  value="2" />CDD
          <input type="radio" name="cdx"  value="3" checked="true" />Autre <xsl:value-of select="nature"/>
          
        
       </xsl:if>
      </xsl:if>
      </tr>
      <tr>
      <tr><b>Convention collective:</b></tr><tr><xsl:value-of select="convcoll"/></tr>
      <xsl:choose>
                <xsl:when test="rompu = 'true'">
                
                </xsl:when>
                <xsl:otherwise>
              </xsl:otherwise>
      </xsl:choose>
      </tr> 
      </xsl:for-each>  
    
        <tr> <td>
       <tr><b>Rupture du contrat ?</b>
        
        
        <xsl:for-each select="guiManager/rupture">
              <xsl:choose>
                <xsl:when test="motif = ''">
                  Non
                </xsl:when> 
                <xsl:otherwise>
                      <xsl:value-of select="description"/><xsl:value-of select="motif"/>
              </xsl:otherwise>
               </xsl:choose>
         </xsl:for-each>
        </tr>
        </td>

      <td>
    <tr><b>Salarié protégé?</b>:
     <xsl:choose>
     <xsl:when test="guiManager/salarieprotege/description = ''">
      Non
      </xsl:when>
      <xsl:otherwise>
       oui,<xsl:value-of select="guiManager/salarieprotege/description"/>
       </xsl:otherwise>
      </xsl:choose>
     </tr>
     </td> 
        </tr>
    <tr><td><b>Représenté ?</b>
     <xsl:choose>
     <xsl:when test="guiManager/demandeur/represente = 'true'">
              <xsl:choose>
                <xsl:when test="guiManager/demandeur/representant/personnephysique = 'true'">
                  <xsl:value-of select="guiManager/demandeur/representant/representant/civilite"/>&#160; 
                  <xsl:value-of select="guiManager/demandeur/representant/representant/nm"/>&#160;
                  <xsl:value-of select="guiManager/demandeur/representant/representant/pnm"/>
                </xsl:when>
                <xsl:otherwise>
                  <xsl:value-of select="guiManager/demandeur/representant/societe/nm"/>&#160;
                  <xsl:value-of select="guiManager/demandeur/representant/societe/pnm"/>
              </xsl:otherwise>
            </xsl:choose>
      </xsl:when>
      <xsl:otherwise>
       ...
       </xsl:otherwise>
      </xsl:choose>
      </td>
      
      

    <td><b>Asisté ?</b>:
     <xsl:choose>
     <xsl:when test="guiManager/demandeur/assiste = 'true'">
         <xsl:choose>
                <xsl:when test="guiManager/demandeur/assistant/personnephysique = 'true'">
                  <xsl:value-of select="guiManager/demandeur/assistant/representant/civilite"/>&#160;
                  <xsl:value-of select="guiManager/demandeur/assistant/representant/nm"/>&#160;
                  <xsl:value-of select="guiManager/demandeur/assistant/representant/pnm"/>
                </xsl:when>
                <xsl:otherwise>
                  <xsl:value-of select="guiManager/demandeur/assistant/societe/nm"/>&#160;
                  <xsl:value-of select="guiManager/demandeur/assistant/societe/pnm"/>
              </xsl:otherwise>
            </xsl:choose>
           </xsl:when>
      <xsl:otherwise>
       ...
       </xsl:otherwise>
      </xsl:choose>
     </td></tr> 
         
          </tr>
          
          </tr>
          
          </td>  
        
        </tr>
       
        <tr>
          <td valign="top" >
          
          <table border="1" width="100%" ><tr>BUREAU DE CONCILIATION DU :</tr><tr>................................................</tr><tr></tr><tr></tr></table>
           <table border="1" width="100%" ><tr>BUREAU DE JUGEMENT DU :</tr><tr>................................................</tr><tr></tr><tr></tr></table>
           <table border="1" width="100%" ><tr>Saisine directe  </tr><tr></tr><tr></tr></table>
              <table border="1" width="100%"  height="50%"><tr>Timbres fiscaux :</tr><tr>................................................</tr><tr></tr><tr></tr></table>
          </td>
          <td valign="top">
          
          
  
     <tr><u><h2>A l'encontre du Defendeur</h2></u></tr>
     
    
       <tr><td>
      <tr><xsl:if test="guiManager/defendeur/salarie = 'false'">
         <b>Il s'agit d'une société</b>
     <xsl:for-each select="guiManager/defendeur/societe">
       <tr><b>Nom</b>:<xsl:value-of select="nm"/></tr>
       <tr><b>Nom Commercial</b>:<xsl:value-of select="nmcom"/></tr>
       <tr><b>SIREN/SIRET</b>:<xsl:value-of select="siret"/></tr>
       <tr><b>CODE NAF/APE</b>:<xsl:value-of select="nafape"/></tr>
       <tr><b>Convention collective :</b>:<xsl:value-of select="convcoll"/></tr>
            <tr><b>Adresse</b></tr>
      <tr><xsl:value-of select="addr/adrline1"/></tr>
      <tr><xsl:value-of select="addr/adrline2"/></tr>
      <tr><xsl:value-of select="addr/adrline3"/></tr>
      <tr><b>Code postal :</b><xsl:value-of select="addr/pstcd"/><b> Ville :</b><xsl:value-of select="addr/twnnm"/></tr>
       </xsl:for-each>
       
       </xsl:if>
       </tr>
       <tr>
       <xsl:if test="guiManager/defendeur/salarie = 'true'">
            <tr><b>Il s'agit d'une personne physique</b></tr>
            <xsl:for-each select="guiManager/defendeur/personne">
       <tr><b>Nom</b>:<xsl:value-of select="nm"/></tr>
       <tr><b>Prénom</b>:<xsl:value-of select="pnm"/></tr>
      <tr><b>Adresse</b></tr>
      <tr><xsl:value-of select="addr/adrline1"/></tr>
      <tr><xsl:value-of select="addr/adrline2"/></tr>
      <tr><xsl:value-of select="addr/adrline3"/></tr>
      <tr><b>Code postal :</b><xsl:value-of select="addr/pstcd"/><b> Ville :</b><xsl:value-of select="addr/twnnm"/></tr>
       </xsl:for-each>
       
       </xsl:if>
       </tr></td>
         <td>
        <tr>Nombre de salariés :<xsl:value-of select="guiManager/defendeur/societe/effectif"/></tr>
     <xsl:choose>
     <xsl:when test="guiManager/defendeur/societe/effectif > 499">
            <tr><input type="radio" name="eff"  value="499" checked="true" /> Plus de 500 <input type="radio" name="eff"  value="49"  /> de 50 à 499</tr>
            <tr><input type="radio" name="eff"  value="9"  /> de 10 à 49 <input type="radio" name="eff"  value="9"  /> moins de 10</tr> 
      </xsl:when>
     <xsl:when test="guiManager/defendeur/societe/effectif > 49">
            <tr><input type="radio" name="eff"  value="499"  /> Plus de 500</tr>
            <tr><input type="radio" name="eff"  value="49" checked="true" /> de 50 à 499</tr>
            <tr><input type="radio" name="eff"  value="9" /> de 10 à 49</tr>
            <tr><input type="radio" name="eff"  value="0"  /> moins de 10</tr> 
      </xsl:when>
     <xsl:when test="guiManager/defendeur/societe/effectif > 9">
            <tr><input type="radio" name="eff"  value="499" /> Plus de 500</tr>
            <tr><input type="radio" name="eff"  value="49"  /> de 50 à 499</tr>
            <tr><input type="radio" name="eff"  value="9" checked="true" /> de 10 à 49</tr>
            <tr><input type="radio" name="eff"  value="0"  /> moins de 10</tr> 
      </xsl:when>
     <xsl:when test="guiManager/defendeur/societe/effectif > 0">
            <tr><input type="radio" name="eff"  value="499"  /> Plus de 500</tr>
            <tr><input type="radio" name="eff"  value="49"  /> de 50 à 499</tr>
            <tr><input type="radio" name="eff"  value="9"  /> de 10 à 49</tr>
            <tr><input type="radio" name="eff"  value="0" checked="true" /> moins de 10</tr> 
      </xsl:when>

       <xsl:otherwise>
    </xsl:otherwise>
     </xsl:choose></td></tr>
       <tr><td>
      <tr><tr><b>Redressement</b></tr>
     <xsl:choose>
     <xsl:when test="guiManager/defendeur/societe/redressement = 'true'">
     
        <xsl:for-each select="guiManager/defendeur/societe/idredressement">
                 <tr><b>Administrateur judiciaire</b></tr>
                   
                      <tr><b>Nom</b>:<xsl:value-of select="admin/nm"/></tr><tr> 
                        <b>Prénom</b>:<xsl:value-of select="admin/pnm"/></tr><tr> 
                        <b>Téléphone</b>:<xsl:value-of select="admin/tel/pnumber"/></tr><tr>
                      <b>Adresse :</b>
                      <xsl:value-of select="admin/addr/adrline1"/></tr><tr>
                      <xsl:value-of select="admin/addr/adrline2"/></tr><tr>
                      <xsl:value-of select="admin/addr/adrline3"/></tr><tr>
                        <b>Code postal :</b><xsl:value-of select="admin/addr/pstcd"/><b> Ville :</b><xsl:value-of select="admin/addr/twnnm"/></tr>
                  
                    <tr><b>Representant des créditeurs</b></tr>
                    <tr><b>Nom</b>:<xsl:value-of select="creditorrepr/nm"/></tr><tr>
                        <b>Prénom</b>:<xsl:value-of select="creditorrepr/pnm"/></tr><tr>
                         <b>Téléphone</b>:<xsl:value-of select="creditorrepr/tel/pnumber"/></tr>
                        <tr><b>Adresse :</b>
                        <xsl:value-of select="creditorrepr/addr/adrline1"/></tr>
                            <tr><xsl:value-of select="creditorrepr/addr/adrline2"/>
                            <xsl:value-of select="creditorrepr/addr/adrline3"/></tr><tr>
                            <b>Code postal :</b><xsl:value-of select="creditorrepr/addr/pstcd"/><b> Ville :</b><xsl:value-of select="creditorrepr/addr/twnnm"/></tr>
                    
    
   </xsl:for-each>
    </xsl:when>
    <xsl:otherwise>
    </xsl:otherwise>
    </xsl:choose>
    </tr>
      
     </td><td> 
    <tr><tr><b>Liquidation</b></tr>
    <tr><b>Liquidateur</b></tr  >
    
     <xsl:choose>
     <xsl:when test="guiManager/defendeur/societe/liquidation = 'true'">
     
     
     <xsl:for-each select="guiManager/defendeur/societe/idliquidation">
     <tr><b>Nom</b>:<xsl:value-of select="liquidateur/nm"/></tr>
     <tr><b>Prénom</b>:<xsl:value-of select="liquidateur/pnm"/></tr>
     <tr><b>Téléphone</b>:<xsl:value-of select="liquidateur/tel/pnumber"/></tr>
      
           <tr><b>Adresse :</b>
      <xsl:value-of select="liquidateur/addr/adrline1"/></tr>
      <tr><xsl:value-of select="liquidateur/addr/adrline2"/>
      <xsl:value-of select="liquidateur/addr/adrline3"/></tr>
      <tr><b>Code postal :</b><xsl:value-of select="liquidateur/addr/pstcd"/> <b> Ville :</b> <xsl:value-of select="liquidateur/addr/twnnm"/></tr>
      
      </xsl:for-each>
     
     
      </xsl:when>
      <xsl:otherwise>
       ...
       </xsl:otherwise>
      </xsl:choose>
        
      </tr>
      
      
       <xsl:if test="guiManager/defendeur/societe/ags = 'true'">
     <tr> <input type="radio" name="dcs"  value="2" checked="true"  />CGEA-AGS consernés :<xsl:value-of select="guiManager/defendeur/societe/agscgea"/></tr>    
    </xsl:if> 
      </td></tr>   
          </td>
        </tr>
        
        <tr>
        
          <td/>
        <tr><td colspan="2"><h2><u>Chefs de demandes</u></h2></td></tr>
<tr>
  
<td >Art.</td>
<td>Libellé</td>
<td >Periode</td>
<td >Montant EUR</td>
<td >Précision</td>
</tr>
<xsl:for-each select="guiManager/demandes">


        <xsl:if test="selected = 'true'">
        
        <tr>
        <td><xsl:value-of select="artlaw"/></td>
        <td><xsl:value-of select="lbl"/></td>
        <td><xsl:value-of select="dt"/>-<xsl:value-of select="dt"/></td>
        <td><xsl:value-of select="amount"/></td>
        <td><xsl:value-of select="precision"/></td>
        
       </tr>
       </xsl:if>

</xsl:for-each>
</tr>
<tr>
<td></td><td>Total</td><td><tr>Date</tr><tr> ............</tr></td><td><tr>Signature</tr><tr>_______________</tr></td>
</tr>
      
    </table>
      </tbody>
  </body>
</html>
</xsl:template>

</xsl:stylesheet>

