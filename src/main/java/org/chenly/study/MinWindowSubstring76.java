package org.chenly.study;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 *
 * @author chenly
 * @create 2020-11-20 22:01
 */
public class MinWindowSubstring76 {
	//超时
	/*	public static String minWindow(String s, String t) {
			if(s.length()<t.length()){
				return "";
			}
			int windowsLength = t.length();
			while (windowsLength<=s.length()){
				String windows = "";
				int left = 0;
				int right = windowsLength;
				while (windows.length() <= s.length()) {

					windows = s.substring(left, right);
					if (equals(windows, t)) {
						return windows;
					} else {
						left = left + 1;
						right = right + 1;
						if (right > s.length()) {
							break;
						}
					}

				}
				windowsLength++;

			}

			return "";

		}*/

	//字符串过长 超时
	/*public static String minWindow1(String s, String t) {
		if (s.length() < t.length()) {
			return "";
		}
		Map<Integer, String> integerStringMap = new HashMap<>();

		String windows = "";

		int left = 0;
		int right = t.length();
		while (right <= s.length()) {
			windows = s.substring(left, right);
			if (equals(windows, t)) {
				left++;
				integerStringMap.put(windows.length(), windows);
			} else {
				right++;
			}
		}

		return integerStringMap.entrySet()
				.stream()
				.min(Map.Entry.comparingByKey())
				.map(Map.Entry::getValue)
				.orElse("");

	}

	private static boolean equals(String temp, String t) {
		char[] chars1 = t.toCharArray();
		int a = 0;
		for (char c : chars1) {
			if (temp.indexOf(c) != -1) {
				a++;
				temp = temp.substring(0, temp.indexOf(c)) + temp.substring(temp.indexOf(c) + 1);
			}
		}
		return a == t.length();
	}*/

/*	public static String minWindow(String s, String t) {
		if (s.length() < t.length()) {
			return "";
		}
		Map<Character, Integer> originMap = new HashMap<>(171);
		Map<Character, Integer> windowsMap = new HashMap<>(171);

		for (char c : t.toCharArray()) {
			originMap.compute(c, add());
		}

		Map<Integer, String> integerStringMap = new HashMap<>();

		int left = 0;
		int right = 0;
		String windows = "";
		while (right < s.length()) {
			char rightChar = s.charAt(right);
			if (originMap.containsKey(rightChar)) {
				windowsMap.compute(rightChar, add());

				while (equal(windowsMap, originMap) && left <= right) {
					windows = s.substring(left, right + 1);
					integerStringMap.put(windows.length(), windows);

					char leftChar = s.charAt(left);
					if (originMap.containsKey(leftChar)) {
						windowsMap.compute(leftChar, sub());

					}
					left++;
				}

			}
			right++;

		}
		return integerStringMap.entrySet()
				.stream()
				.min(Map.Entry.comparingByKey())
				.map(Map.Entry::getValue)
				.orElse("");
	}*/

	public static String minWindow(String s, String t) {
		if (s.length() < t.length()) {
			return "";
		}
		Map<Character, Integer> originMap = new HashMap<>();
		Map<Character, Integer> windowsMap = new HashMap<>();

		for (char c : t.toCharArray()) {
			originMap.compute(c, add());
		}

		int left = 0;
		int right = 0;
		String windows = "";
		int min = Integer.MAX_VALUE;
		while (right < s.length()) {
			char rightChar = s.charAt(right);
			if (originMap.containsKey(rightChar)) {
				windowsMap.compute(rightChar, add());

				while (equal(windowsMap, originMap) && left <= right) {

					if (right - left + 1 < min) {
						windows = s.substring(left, right + 1);
						min = right - left + 1;
					}
					char leftChar = s.charAt(left);
					if (originMap.containsKey(leftChar)) {
						windowsMap.compute(leftChar, sub());

					}
					left++;
				}

			}
			right++;

		}
		return windows;
	}

	private static BiFunction<Character, Integer, Integer> sub() {
		return (character, integer) -> {
			if (integer == null) {
				return 0;
			}
			return --integer;
		};
	}

	private static BiFunction<Character, Integer, Integer> add() {
		return (character, integer) -> {
			if (integer == null) {
				return 1;
			}
			return ++integer;
		};
	}

	private static boolean equal(Map<Character, Integer> windowsMap, Map<Character, Integer> originMap) {
		return originMap.entrySet()
				.stream()
				.allMatch(entry -> windowsMap.getOrDefault(entry.getKey(), 0) >= entry.getValue());

	}

	public static void main(String[] args) {

		/*System.out.println(minWindow(
				"obzcopzocynyrsgsarijyxnkpnukkrvzuwdjldxndmnvevpgmxrmvfwkutwekrffnloyqnntbdohyfqndhzyoykiripdzwiojyoznbtogjyfpouuxvumtewmmnqnkadvzrvouqfbbdiqremqzgevkbhyoznacqwbhtrcjwfkzpdstpjswnpiqxjhywjanhdwavajrhwtwzlrqwmombxcaijzevbtcfsdcuovckoalcseaesmhrrizcjgxkbartdtotpsefsrjmvksqyahpijsrppdqpvmuocofuunonybjivbjviyftsyiicbzxnwnrmvlgkzticetyfcvqcbjvbufdxgcmesdqnowzpshuwcseenwjqhgsdlxatamysrohfnixfprdsljyyfhrnnjsagtuihuczilgvtfcjwgdhpbixlzmakebszxbhrdibpoxiwztshwczamwnninzmqrmpsviydkptjzpktksrortapgpxwojofxeasoyvyprjoguhqobehugwdvtzlenrcttuitsiijswpogicjolfxhiscjggzzissfcnxnvgftxvbfzkukqrtalvktdjsodmtgzqtuyaqvvrbuexgwqzwduixzrpnvegddyyywaquxjxrnuzlmyipuqotkghfkpknqinoidifnfyczzonxydtqroazxhjnrxfbmtlqcsfhshjrxwqvblovaouxwempdrrplefnxmwrwfjtebrfnfanvvmtbzjesctdgbsfnpxlwihalyiafincfcwgdfkvhebphtxukwgjgplrntsuchyjjuqozakiglangxkttsczhnswjksnuqwflmumpexxrznzwxurrysaokwxxqkrggytvsgkyfjrewrcvntomnoazmzycjrjrqemimyhriyxgrzcfuqtjhvjtuhwfzhwpljzajitrhryaqchnuawbxhxrpvyqcvhpggrpplhychyulijhkglinibedauhvdydkqszdbzfkzbvhldstocgydnbfjkcnkfxcyyfbzmmyojgzmasccaahpdnzproaxnexnkamwmkmwslksfpwirexxtymkmojztgmfhydvlqtddewjvsrmyqjrpycbmndhupmdqqabiuelacuvxnhxgtpvrtwfgzpcrbhhtikbcqpctlxszgpfbgcsbaaiapmtsucocmpecgixshrrnhyrpalralbccnxvjzjllarqhznzghswqsnfuyywmzbopyjyauknxddgdthlabjqtwxpxwljvoxkpjjpfvccyikbbrpdsyvlxscuoofkecwtnfkvcnzbxkeabtdusyhrqklhaqreupakxkfzxgawqfwsaboszvlshwzhosojjotgyagygguzntrouhiweuomqptfjjqsxlbylhwtpssdlltgubczxslqjgxuqnmpynnlwjgmebrpokxjnbiltvbebyytnnjlcwyzignmhedwqbfdepqakrelrdfesqrumptwwgifmmbepiktxavhuavlfaqxqhreznbvvlakzeoomykkzftthoemqwliednfsqcnbexbimrvkdhllcesrlhhjsspvfupxwdybablotibypmjutclgjurbmhztboqatrdwsomnxnmocvixxvfiqwmednahdqhxjkvcyhpxxdmzzuyyqdjibvmfkmonfxmohhshpkhmntnoplphqyprveyfsmsxjfosmicdsjrieeytpnbhlsziwxnpmgoxneqbnufhfwrjbqcsdfarybzwaplmxckkgclvwqdbpumsmqkswmjwnkuqbicykoisqwoootrdpdvcuiuswfqmrkctsgrevcxnyncmivsxbpbxzxpwchiwtkroqisnmrbmefbmatmdknaklpgpyqlsccgunaibsloyqpnsibwuowebomrmcegejozypjzjunjmeygozcjqbnrpakdermjcckartbcppmbtkhkmmtcngteigjnxxyzaibtdcwutkvpwezisskfaeljmxyjwykwglqlnofhycwuivdbnpintuyhtyqpwaoelgpbuwiuyeqhbvkqlsfgmeoheexbhnhutxvnvfjwlzfmvpcghiowocdsjcvqrdmkcizxnivbianfpsnzabxqecinhgfyjrjlbikrrgsbgfgyxtzzwwpayapfgueroncpxogouyrdgzdfucfrywtywjeefkvtzxlwmrniselyeodysirqflpduvibfdvedgcrzpzrunpadvawfsmmddqzaaahfxlifobffbyzqqbtlcpquedzjvykvarayfldvmkapjcfzfbmhscdwhciecsbdledspgpdtsteuafzbrjuvmsfrajtulwirzagiqjdiehefmfifocadxfuxrpsemavncdxuoaetjkavqicgndjkkfhbvbhjdcygfwcwyhpirrfjziqonbyxhibelinpllxsjzoiifscwzlyjdmwhnuovvugfhvquuleuzmehggdfubpzolgbhwyeqekzccuypaspozwuhbzbdqdtejuniuuyagackubauvriwneeqfhtwkocuipcelcfrcjcymcuktegiikyosumeioatfcxrheklookaqekljtvtdwhxsteajevpjviqzudnjnqbucnfvkybggaybebljwcstmktgnipdyrxbgewqczzkaxmeazpzbjsntltjwlmuclxirwytvxgvxscztryubtjweehapvxrguzzsatozzjytnamfyiitreyxmanhzeqwgpoikcjlokebksgkaqetverjegqgkicsyqcktmwjwakivtsxjwrgakphqincqrxqhzbcnxljzwturmsaklhnvyungjrxaonjqomdnxpnvihmwzphkyuhwqwdboabepmwgyatyrgtboiypxfavbjtrgwswyvcqhzwibpisydtmltbkydhznbsvxktyfxopwkxzbftzknnwipghuoijrbgqnzovxckvojvsqqraffwowfvqvfcmiicwitrhxdeombgesxexedlakitfovtydxunqnwqqdeeekiwjnwoshqcsljiicgobbbuqakjdonjawgjlezdnqhfdqnmsuavxdpnfzwipmspiabveaarshzwxmirgkmfncvtdrdvfxkpxlkdokxgtwcskmjryyymcthfnkasinihaunohkxaibtsqelockaefjmsuolebtnepauwmrxutspjwaxbmahsjtkfkxlnszribmeofbkyvbjscjtqjakuwvcgunvnonvqbbggfshauqsyznokqbhowjusypfnecffenojfvlblgzntqzlrgzprvhqnpfrrkzxznieiuivajivzijsqijigtatifmbplzqahuidegfoobpymkputzamzvweiyvvzlwihgmmmrcburbgbsdxrfjsbiylitghgcpqjbevvgypxcybubyoijijrhuzcdijfybqbfowlookqmlnplbxvjjosfqviygqyhgamuwzjklbyzopkrnhbywtfoqomweldmlrhjqswctubiknzzvcztyehouvnyiqnvkufaobehxhrjvtisxjlxoumipzjarwvbsaegdkpbsjmpevjbewzuqnfhoohhmdjgfpmjzdmtmykqvtucptwfidpwtwffzolffzqfdearclkyeecuzabjeqhxpmfodsvisnpxrqowdawheydfyhoexvcmihdlzavtqlshdhdgjzpozvvackebhgqppvcrvymljfvooauxcjnbejdivikcoaugxwzsulgfqdtefpehbrlhaoqxwcancuvbqutnfbuygoemditeagmcveatgaikwflozgdhkyfqmjcruyyuemwbqwxyyfiwnvlmbovlmccaoguieu",
				"cjgamyzjwxrgwedhsexosmswogckohesskteksqgrjonnrwhywxqkqmywqjlxnfrayykqotkzhxmbwvzstrcjfchvluvbaobymlrcgbbqaprwlsqglsrqvynitklvzmvlamqipryqjpmwhdcsxtkutyfoiqljfhxftnnjgmbpdplnuphuksoestuckgopnlwiyltezuwdmhsgzzajtrpnkkswsglhrjprxlvwftbtdtacvclotdcepuahcootzfkwqhtydwrgqrilwvbpadvpzwybmowluikmsfkvbebrxletigjjlealczoqnnejvowptikumnokysfjyoskvsxztnqhcwsamopfzablnrxokdxktrwqjvqfjimneenqvdxufahsshiemfofwlyiionrybfchuucxtyctixlpfrbngiltgtbwivujcyrwutwnuajcxwtfowuuefpnzqljnitpgkobfkqzkzdkwwpksjgzqvoplbzzjuqqgetlojnblslhpatjlzkbuathcuilqzdwfyhwkwxvpicgkxrxweaqevziriwhjzdqanmkljfatjifgaccefukavvsfrbqshhswtchfjkausgaukeapanswimbznstubmswqadckewemzbwdbogogcysfxhzreafwxxwczigwpuvqtathgkpkijqiqrzwugtr"));
*/
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}
}
