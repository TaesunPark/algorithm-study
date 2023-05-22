public class StringOperations {
    public static int countOverlapWithPrefix(String text, String prefixString) {
        int overlapCount = 0;
        String suffix = prefixString.substring(prefixString.length() - text.length());
        if (text.endsWith(suffix)) {
            overlapCount++;
        }
        return overlapCount;
    }

    public static int countOverlapWithSuffix(String text, String suffixString) {
        int overlapCount = 0;
        String prefix = suffixString.substring(0, text.length());
        if (text.startsWith(prefix)) {
            overlapCount++;
        }
        return overlapCount;
    }

    public static void main(String[] args) {
        String text = "engine";
        String prefixString = "raven";
        String suffixString = "ginkgo";

        int overlapWithPrefix = countOverlapWithPrefix(text, prefixString);
        int overlapWithSuffix = countOverlapWithSuffix(text, suffixString);

        System.out.println("Overlap with prefix: " + overlapWithPrefix);
        System.out.println("Overlap with suffix: " + overlapWithSuffix);
    }
}