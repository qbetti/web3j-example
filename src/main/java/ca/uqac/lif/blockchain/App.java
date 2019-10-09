package ca.uqac.lif.blockchain;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;

public class App {

    // Each unit of gas is worth 10 Wei (1 Wei = 10^-18 ETH)
    public static final BigInteger GAS_PRICE = BigInteger.valueOf(10);
    // The cost of a transaction cannot exceed 6,000,000 gas
    public static final BigInteger GAS_LIMIT = BigInteger.valueOf(6_000_000L);

    public static void main(String[] args) throws Exception {
        // Initiating connection to Ethereum node
        Web3j web3j = Web3j.build(new HttpService("http://localhost:8545"));

        // Loading personal wallet
        Credentials wallet = WalletUtils.loadCredentials(
                "", "wallet.json");

        // Deploying the smart contract
        MyStringStorageContract contract = MyStringStorageContract.deploy(
                web3j, wallet, GAS_PRICE, GAS_LIMIT, "Hello, you!"
        ).send();

        // Printing the contract's address, can be used to be loaded from the blockchain
        System.out.println(contract.getContractAddress());
        System.out.println(contract.getMyString().send());

        // Changing the string stored in the contract
        contract.setMyString("Hello, world!").send();
        System.out.println(contract.getMyString().send());
    }
}
