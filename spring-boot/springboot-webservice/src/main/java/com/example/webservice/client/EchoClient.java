package com.example.webservice.client;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

public class EchoClient {
    private static String endPoint = "http://127.0.0.1:8080/ws_server?wsdl";

    public static void main(String[] args) throws ServiceException, RemoteException {
        System.out.println(getRemoteServiceContent());
    }

    public static String getRemoteServiceContent() throws ServiceException, RemoteException {
        Service service = new Service();
        Call call = (Call)service.createCall();
        call.setTargetEndpointAddress(endPoint);
        call.setOperationName(new QName("http://WebXml.com.cn/","echo"));
        call.addParameter("Lee", org.apache.axis.encoding.XMLType.XSD_DATE,
                javax.xml.rpc.ParameterMode.IN);
        call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置返回类型
        String result = (String)call.invoke(new Object[]{"测试"});
        return result;
    }
}
