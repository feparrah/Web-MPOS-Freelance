package co.com.netcom.security;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;

import org.springframework.security.crypto.codec.Base64;

public class SecurityConfiguration {

	
	
	public static void main(String args[]) throws CertificateException, IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException{
		
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		String lo="-----BEGIN CERTIFICATE-----"
				+ "MIID+zCCAuOgAwIBAgIJAN0DYbYIhyzrMA0GCSqGSIb3DQEBCwUAMIGLMQswCQYDVQQGEwJHQjEYMBYGA1UECBMPQnVja2luZ2hhbXNoaXJlMRUwEwYDVQQHEwxTdG9rZW5jaHVyY2gxGjAYBgNVBAoTEU1pdXJhIFN5c3RlbXMgTHRkMREwDwYDVQQLEwhUZXJtaW5hbDEcMBoGA1UEAxMTMDE2LTM2NzMxNC10ZXJtaW5hbDAeFw0xMDAxMDEwMDAwMDBaFw0yOTEyMzEyMzU5NTlaMIGQMQswCQYDVQQGEwJHQjEYMBYGA1UECBMPQnVja2luZ2hhbXNoaXJlMRUwEwYDVQQHEwxTdG9rZW5jaHVyY2gxGjAYBgNVBAoTEU1pdXJhIFN5c3RlbXMgTHRkMREwDwYDVQQLEwhUZXJtaW5hbDEhMB8GA1UEAxMYMDE2LTM2NzMxNC1sb2NhbC1rZXlsb2FkMIIBIDANBgkqhkiG9w0BAQEFAAOCAQ0AMIIBCAKCAQEAvq+wS/7Mc35r87IPf5I6cGn2y/GmYUMjEfinGCSJw+Tb8I6ss60FOcIf/k0cekGbp6ql2WZbjP+Nb1a/L4bOWJgnItFxNJPNDQuPHCMZCRkHFKaA8aLGeH+vaipLj15eA27T4tE+o6XzNqYBJAadzW1sGL0+MwV6nwy6tTxRScFysSkfUE/+bcq+zAlbFfmwMoeJwZyqqYPeuQr8kDEQDnDny2idgnSaicUAq5OTlvx5LJ2rIyfZbkmg7eEePF3llex8BIzh3N9arwTr4rtDAcrbTqQ+JkP8EKuIdyH4lDen3yDeCs/FG+HWov2UfjVV5fJLNuSKGYLnt4W0Qwf9aQIBA6NdMFswDAYDVR0TAQH/BAIwADALBgNVHQ8EBAMCBSAwHQYDVR0OBBYEFCEUn64rBHU4Iq5GbPDX5cLWek/kMB8GA1UdIwQYMBaAFFKiphzkBkqgZxIRUa3kaTHux71GMA0GCSqGSIb3DQEBCwUAA4IBAQAZlrGXQ2d4dJndkBw8/FyHYtQxeP/YH5pR3gamySEJIi6OXI4gm8PtdkT2iyVgdnAtmax4iOX8DOSJ93mdat8hUuNtVtcVwK7qJ8B75NAY61RLRKuL17Np/fHPntlYLaN28NHI1dXzHqjicmmMJts6osorEJeYPNinlWg7VT2hIrB7ZWqqO7lsPF5xzhrJqWp/Zae42q6OuDrRscZByx/ljpnmPRgG6u4q2yGXVvNeRN6r1o2FhjLWSMftfMK5/fI2+0VYUUjDnp2mqITe72vkr1yb4vHdDIlD+o8EwmkLisBW5wz+i5fzvy/6s+t2hwTM/nJDol3IkhgyRH8x2dyj"
				+ "-----END CERTIFICATE----- ";
		 byte [] decoded = Base64.decode(lo.replaceAll("-----BEGIN CERTIFICATE-----", "").replaceAll("-----END CERTIFICATE-----", "").getBytes());
	    FileInputStream in = new FileInputStream("C://Users//fabian.parra\\Desktop//2.crt");
	    InputStream in2=new ByteArrayInputStream(decoded);
	    java.security.cert.Certificate c = cf.generateCertificate(in);
	    in.close();

	    X509Certificate t = (X509Certificate) c;
	    PublicKey key=t.getPublicKey();
	    RSAPublicKey pub = (RSAPublicKey) key;	    	    
	    System.out.println("Algoritmo: "+ t.getSigAlgName());
	    System.out.println("Exponente: "+pub.getPublicExponent().toString(16).toString());
	    System.out.println("Modulo: "+pub.getModulus().toString(16));
	    System.out.println("Llave publica RSA: "+new BigInteger(t.getTBSCertificate()).toString(16));
	    System.out.println("Firma digital: "+new BigInteger(t.getSignature()).toString(16).toUpperCase());
	    System.out.println("Cert: "+key.toString());
	    for(int i=0;i<t.getKeyUsage().length;i++){
	    	System.out.println("Cert: "+(t.getKeyUsage()[i]));	    	
	    }
	    
	    byte[] encoded =Base64.encode("fabian".getBytes());
	    
	    System.out.println("ll: "+new String(encoded));
	    System.out.println(new String(Base64.decode("SUtTTjogRkZGRkZGMDNFNkZCNDg0MDAwMDAK".getBytes())));
	    
	    System.out.println("IKSN: FFFFFF03E6FB4B600000".substring(6));
	}
}
