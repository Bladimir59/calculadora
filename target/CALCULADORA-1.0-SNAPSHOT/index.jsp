<%-- 
    Document   : index
    Created on : 26/09/2020, 18:42:53
    Author     : bladimir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="calcular">
        <fieldset>
            <legend>
                Calduladora:
            </legend>
            Numero 1: <input type="text" size="30" name="numero1"/>
            <br/> Numero 2: <input type="text" size="30" name="numero2" />
            <br/>
            <select class="form-control form-control-lg" id="exampleFormControlSelect1" name="opcion">
                                <option value="1">Sumar</option>
                                <option value="2">Multiplicar</option>
                                <option value="3">Max</option>
                                <option value="4">Potencia (N1 elevado a N2)</option>
                                <option value="5">Valor Binario</option>
                            </select>
            <br>
            <button type="submit">
                calcular
                </button>
            </br>
            <br>
            resultado <input type="text" size="30" name="resultado"/>               
            </br>
        </fieldset>
    </form>
        
    </body>
</html>
