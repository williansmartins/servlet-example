package br.com.fiap.framework.controller;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class BoletoController {

	private final String CAMINHOXPATH = "/report/data/file/cliente";
	private final String ARQUIVODESTINOPDF = "relatorios/";
	private final String CAMINHOJASPER= "/home/alberto/git/servlet-example/WebContent";//TODO: Alterar de acordo com o caminho do arquivo na maquina.
	public final String XML = "<?xml version=\"1.0\" encoding=\"iso-8859-1\" ?>\n"+ 
					"<report>\n"+
					"\n"+
					"	<data>\n"+
					"\n"+
					"		<file>\n"+
					"		\n"+
					"			<cliente>\n"+
					"				<codigo>00018</codigo>\n"+
					"				<nome>SynapSystem Ltda</nome>\n"+
					"				<endereco>Av. Lins de Vanconcelos, 5000</endereco>\n"+
					"				<cidade>São Paulo</cidade>\n"+
					"				<estado>SP</estado>\n"+
					"				<cnpj>12.000.001/0001-66</cnpj>\n"+
					"			</cliente>\n"+
					"\n"+
					"			<notasfiscaisservico>\n"+
					"				<nota>\n"+
					"					<numero>00012</numero>\n"+
					"					<discriminacaoGeral>Limpeza do ar condicionado.</discriminacaoGeral>\n"+
					"					<data>10/10/2007</data>\n"+
					"					<valor>200,00</valor>\n"+
					"				</nota>\n"+
					"				<nota>\n"+
					"					<numero>00013</numero>\n"+
					"					<discriminacaoGeral>Conserto do sistema de iluminação.</discriminacaoGeral>\n"+
					"					<data>15/10/2007</data>\n"+
					"					<valor>500,00</valor>\n"+
					"				</nota>\n"+
					"				<nota>\n"+
					"					<numero>00016</numero>\n"+
					"					<discriminacaoGeral>Troca do piso dos andares inferiores.</discriminacaoGeral>\n"+
					"					<data>15/10/2007</data>\n"+
					"					<valor>300,00</valor>\n"+
					"				</nota>\n"+
					"				<nota>\n"+
					"					<numero>00017</numero>\n"+
					"					<discriminacaoGeral>Troca do piso dos andares superiores.</discriminacaoGeral>\n"+
					"					<data>18/10/2007</data>\n"+
					"					<valor>500,00</valor>\n"+
					"				</nota>\n"+
					"			</notasfiscaisservico>\n"+
					"\n"+
					"			<boleto>\n"+
					"				<codigoBarra>34191690282945517091900827590001124999</codigoBarra>\n"+
					"				<nomeBanco>Banco FIAP</nomeBanco>\n"+
					"				<observacao>Após vencimento deverá ser cobrado multa de R$ 1,00 ao dia.</observacao>\n"+
					"				<dataDocumento>23/11/2007</dataDocumento>\n"+
					"				<dataVencimento>01/12/2007</dataVencimento>\n"+
					"				<valorDocumento>1500,00</valorDocumento>\n"+
					"				<multa>0,00</multa>\n"+
					"				<valorCobrado>1500,00</valorCobrado>\n"+
					"			</boleto>\n"+
					"\n"+
					"		</file>\n"+
					"\n"+
					"	</data>\n"+
					"\n"+
					"</report>";
	
	public String gerarRelatorioPDF(String nomeRelatorio, String raizDeContexto, String xml) throws FileNotFoundException {
		ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes());
		JRExporter exporter = null;
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("dataatual", new Date());
			JRXmlDataSource jrxmlds = new JRXmlDataSource(bais, CAMINHOXPATH);
			JasperReport jasperReport = JasperCompileManager.compileReport(raizDeContexto + "/Boleto.jrxml");
			JasperPrint print = JasperFillManager.fillReport(jasperReport, map, jrxmlds);
			exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, (raizDeContexto + ARQUIVODESTINOPDF + nomeRelatorio + ".pdf"));
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.exportReport();
			System.out.println("Relat\u00f3rio PDF gerado com sucesso.");
			return (ARQUIVODESTINOPDF + nomeRelatorio + ".pdf");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}