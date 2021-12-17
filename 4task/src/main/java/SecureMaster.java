import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class SecureMaster {
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final byte[] bytes = new byte[32];
    private static final SHA3.Digest256 sha3_256 = new SHA3.Digest256();

    public static String getHMACKey() {
        secureRandom.nextBytes(bytes);
        return Hex.toHexString(bytes);
    }

    public static String getHMACKeyForMove(String move) {
        return Hex.toHexString(sha3_256.digest((Hex.toHexString(bytes) + move).getBytes(StandardCharsets.UTF_8)));
    }
}
