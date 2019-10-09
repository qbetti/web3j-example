pragma solidity >=0.4.22 <0.6.0;
contract MyStringStorageContract {
    
    string myString;
    
    event OnStringChange(
        string oldString,
        string newString
    );
    
    constructor(string memory _myString) public {
        myString = _myString;
    }
    
    function getMyString() external view returns (string memory _myString) {
        _myString = myString;
    }
    
    function setMyString(string memory _myNewString) public {
        string memory oldString = myString;
        myString = _myNewString;
        emit OnStringChange(oldString, myString);
    } 
}

