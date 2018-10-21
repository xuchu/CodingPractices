package com.leetcode;

import java.util.Optional;

public class Trie {
    private class TrieNode {
        private TrieNode[] childNodes;
        boolean isWordFinished;
        TrieNode(){
            childNodes = new TrieNode[Trie.ALPHABET_SIZE];
        }

        Optional<TrieNode> getChildNode(int index){
            if(index < 0 || index >= ALPHABET_SIZE){
                throw new IllegalArgumentException("index doesnot exist in children of the Node");
            }
            return Optional.ofNullable(childNodes[index]);
        }

        TrieNode createNewChildNode(int index) {
            TrieNode node = new TrieNode();
            childNodes[index] = node;
            return node;
        }
    }

    public static final int ALPHABET_SIZE = 26;
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if( word.length() == 0 )
            return;
        insertHelper(word, root);
    }

    private void insertHelper(String word, TrieNode node){
        char firstChar = word.charAt(0);
        int index = computeCharIndex(firstChar);
        TrieNode childNode = node.getChildNode(index).orElse(node.createNewChildNode(index));
        if( word.length() == 1 ){
            childNode.isWordFinished = true;
            return;
        }
        String restStr = word.substring(1);
        insertHelper(restStr, childNode);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Optional<TrieNode> trieNode = searchHelper(word, root);
        if( trieNode.isPresent() && trieNode.get().isWordFinished ){
            return true;
        }
        return false;
    }

    private Optional<TrieNode> searchHelper(String word, TrieNode node){
        char firstChar = word.charAt(0);
        int index = computeCharIndex(firstChar);
        Optional<TrieNode> childNode = node.getChildNode(index);
        if( !childNode.isPresent() || word.length() == 1 ){
            return childNode;
        }
        String restStr = word.substring(1);
        return searchHelper(restStr, childNode.get());
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Optional<TrieNode> trieNode = searchHelper(prefix, root);
        if( trieNode.isPresent() ){
            return true;
        }
        return false;
    }

    private int computeCharIndex(char c){
        int index = Character.toLowerCase(c) - 'a';
        if( index < 0 || index > ALPHABET_SIZE ){
            throw  new IllegalArgumentException("index doesnot exist");
        }
        return index;
    }
}
