package br.com.fiap.framework.controller;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.fiap.framework.entidades.Cliente;
import br.com.fiap.framework.entidades.ClienteVO;
import br.com.fiap.framework.entidades.NotaFiscalServico;
import br.com.fiap.framework.entidades.NotaFiscalServicoVO;
import br.com.fiap.framework.entidades.Relatorio;
import br.com.fiap.framework.entidades.Report;

public class ConversorEntidadeXML {

	public String gerarXML(ClienteVO vo) throws JAXBException {
		StringWriter sw = new StringWriter();
		JAXBContext jaxbContext = JAXBContext.newInstance(ClienteVO.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(vo, sw);
		return sw.toString();
	}
	
	public String gerarXML(Cliente cliente) throws JAXBException {
		StringWriter sw = new StringWriter();
		JAXBContext jaxbContext = JAXBContext.newInstance(Cliente.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(cliente, sw);
		return sw.toString();
	}
	
	public String gerarXML(NotaFiscalServico nfs) throws JAXBException  {
		StringWriter sw = new StringWriter();
		JAXBContext jaxbContext = JAXBContext.newInstance(NotaFiscalServico.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(nfs, sw);
		return sw.toString();
	}
	
	public String gerarXML(NotaFiscalServicoVO vo) throws JAXBException  {
		StringWriter sw = new StringWriter();
		JAXBContext jaxbContext = JAXBContext.newInstance(NotaFiscalServicoVO.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(vo, sw);
		return sw.toString();
	}
	
	public String gerarXML(Report relatorio) throws JAXBException  {
		StringWriter sw = new StringWriter();
		JAXBContext jaxbContext = JAXBContext.newInstance(Report.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(relatorio, sw);
		return sw.toString();
	}
	
	public String gerarXML(Relatorio relatorio) throws JAXBException {
		StringWriter sw = new StringWriter();
		JAXBContext context = JAXBContext.newInstance(Relatorio.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(relatorio, sw);
		return sw.toString();
	}
	
	public NotaFiscalServico getNota(String xml) throws JAXBException  {
		JAXBContext jaxbContext = JAXBContext.newInstance(NotaFiscalServico.class);
		StringReader leitor = new StringReader(xml);
		Unmarshaller conversor = jaxbContext.createUnmarshaller();
		return (NotaFiscalServico) conversor.unmarshal(leitor);
	}
	
	public Cliente getCliente(String xml) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Cliente.class);
		StringReader leitor = new StringReader(xml);
		Unmarshaller conversor = jaxbContext.createUnmarshaller();
		return (Cliente) conversor.unmarshal(leitor);
	}

	public Report getRelatorio(String xml) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Report.class);
		StringReader leitor = new StringReader(xml);
		Unmarshaller conversor = jaxbContext.createUnmarshaller();
		Report relatorio = (Report) conversor.unmarshal(leitor);
		return relatorio;
	}
}