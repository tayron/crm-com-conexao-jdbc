/**
 * ServicoValidacaoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.curso.seguranca.validacao;

public class ServicoValidacaoServiceLocator extends org.apache.axis.client.Service implements br.com.curso.seguranca.validacao.ServicoValidacaoService {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServicoValidacaoServiceLocator() {
    }


    public ServicoValidacaoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicoValidacaoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicoValidacao
    private java.lang.String ServicoValidacao_address = "http://localhost:8080/ValidacaoSeguranca/services/ServicoValidacao";

    public java.lang.String getServicoValidacaoAddress() {
        return ServicoValidacao_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicoValidacaoWSDDServiceName = "ServicoValidacao";

    public java.lang.String getServicoValidacaoWSDDServiceName() {
        return ServicoValidacaoWSDDServiceName;
    }

    public void setServicoValidacaoWSDDServiceName(java.lang.String name) {
        ServicoValidacaoWSDDServiceName = name;
    }

    public br.com.curso.seguranca.validacao.ServicoValidacao getServicoValidacao() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicoValidacao_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicoValidacao(endpoint);
    }

    public br.com.curso.seguranca.validacao.ServicoValidacao getServicoValidacao(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.com.curso.seguranca.validacao.ServicoValidacaoSoapBindingStub _stub = new br.com.curso.seguranca.validacao.ServicoValidacaoSoapBindingStub(portAddress, this);
            _stub.setPortName(getServicoValidacaoWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicoValidacaoEndpointAddress(java.lang.String address) {
        ServicoValidacao_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.com.curso.seguranca.validacao.ServicoValidacao.class.isAssignableFrom(serviceEndpointInterface)) {
                br.com.curso.seguranca.validacao.ServicoValidacaoSoapBindingStub _stub = new br.com.curso.seguranca.validacao.ServicoValidacaoSoapBindingStub(new java.net.URL(ServicoValidacao_address), this);
                _stub.setPortName(getServicoValidacaoWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ServicoValidacao".equals(inputPortName)) {
            return getServicoValidacao();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://validacao.seguranca.curso.com.br", "ServicoValidacaoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://validacao.seguranca.curso.com.br", "ServicoValidacao"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicoValidacao".equals(portName)) {
            setServicoValidacaoEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
