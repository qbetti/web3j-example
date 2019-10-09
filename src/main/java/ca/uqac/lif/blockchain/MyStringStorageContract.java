package ca.uqac.lif.blockchain;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.4.1.
 */
public class MyStringStorageContract extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060405161062f38038061062f8339818101604052602081101561003357600080fd5b810190808051604051939291908464010000000082111561005357600080fd5b90830190602082018581111561006857600080fd5b825164010000000081118282018810171561008257600080fd5b82525081516020918201929091019080838360005b838110156100af578181015183820152602001610097565b50505050905090810190601f1680156100dc5780820380516001836020036101000a031916815260200191505b50604052505081516100f6915060009060208401906100fd565b5050610198565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061013e57805160ff191683800117855561016b565b8280016001018555821561016b579182015b8281111561016b578251825591602001919060010190610150565b5061017792915061017b565b5090565b61019591905b808211156101775760008155600101610181565b90565b610488806101a76000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c80637e7b8a961461003b57806382180568146100b8575b600080fd5b610043610160565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561007d578181015183820152602001610065565b50505050905090810190601f1680156100aa5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b61015e600480360360208110156100ce57600080fd5b8101906020810181356401000000008111156100e957600080fd5b8201836020820111156100fb57600080fd5b8035906020019184600183028401116401000000008311171561011d57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506101f6945050505050565b005b60008054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156101ec5780601f106101c1576101008083540402835291602001916101ec565b820191906000526020600020905b8154815290600101906020018083116101cf57829003601f168201915b5050505050905090565b60008054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156102825780601f1061025757610100808354040283529160200191610282565b820191906000526020600020905b81548152906001019060200180831161026557829003601f168201915b5050855193945061029e936000935060208701925090506103b8565b507f111001b6e910b4bc28d7ce89cedbc9373246f8bc6efabd2d8001b7dc6de35fb5816000604051808060200180602001838103835285818151815260200191508051906020019080838360005b838110156103045781810151838201526020016102ec565b50505050905090810190601f1680156103315780820380516001836020036101000a031916815260200191505b508381038252845460026000196101006001841615020190911604808252602090910190859080156103a45780601f10610379576101008083540402835291602001916103a4565b820191906000526020600020905b81548152906001019060200180831161038757829003601f168201915b505094505050505060405180910390a15050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106103f957805160ff1916838001178555610426565b82800160010185558215610426579182015b8281111561042657825182559160200191906001019061040b565b50610432929150610436565b5090565b61045091905b80821115610432576000815560010161043c565b9056fea265627a7a7231582084e30cea923f1b8e489104c8b36f6ec95610cf5d76255dc1d6ad87ae59cf8a1e64736f6c634300050b0032";

    public static final String FUNC_GETMYSTRING = "getMyString";

    public static final String FUNC_SETMYSTRING = "setMyString";

    public static final Event ONSTRINGCHANGE_EVENT = new Event("OnStringChange", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
    ;

    @Deprecated
    protected MyStringStorageContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MyStringStorageContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MyStringStorageContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MyStringStorageContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> getMyString() {
        final Function function = new Function(FUNC_GETMYSTRING, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setMyString(String _myNewString) {
        final Function function = new Function(
                FUNC_SETMYSTRING, 
                Arrays.<Type>asList(new Utf8String(_myNewString)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<OnStringChangeEventResponse> getOnStringChangeEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(ONSTRINGCHANGE_EVENT, transactionReceipt);
        ArrayList<OnStringChangeEventResponse> responses = new ArrayList<OnStringChangeEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            OnStringChangeEventResponse typedResponse = new OnStringChangeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.oldString = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.newString = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OnStringChangeEventResponse> onStringChangeEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, OnStringChangeEventResponse>() {
            @Override
            public OnStringChangeEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(ONSTRINGCHANGE_EVENT, log);
                OnStringChangeEventResponse typedResponse = new OnStringChangeEventResponse();
                typedResponse.log = log;
                typedResponse.oldString = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.newString = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OnStringChangeEventResponse> onStringChangeEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ONSTRINGCHANGE_EVENT));
        return onStringChangeEventFlowable(filter);
    }

    @Deprecated
    public static MyStringStorageContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MyStringStorageContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MyStringStorageContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MyStringStorageContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MyStringStorageContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MyStringStorageContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MyStringStorageContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MyStringStorageContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MyStringStorageContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _myString) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Utf8String(_myString)));
        return deployRemoteCall(MyStringStorageContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<MyStringStorageContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _myString) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Utf8String(_myString)));
        return deployRemoteCall(MyStringStorageContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MyStringStorageContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _myString) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Utf8String(_myString)));
        return deployRemoteCall(MyStringStorageContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MyStringStorageContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _myString) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Utf8String(_myString)));
        return deployRemoteCall(MyStringStorageContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class OnStringChangeEventResponse extends BaseEventResponse {
        public String oldString;

        public String newString;
    }
}
