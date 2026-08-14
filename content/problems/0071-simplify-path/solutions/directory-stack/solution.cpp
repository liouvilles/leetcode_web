class Solution {
public:
    string simplifyPath(string path) {
        vector<string> stack; string part; stringstream stream(path);
        while (getline(stream, part, '/')) { if (part.empty() || part == ".") continue; if (part == "..") { if (!stack.empty()) stack.pop_back(); } else stack.push_back(part); }
        string answer; for (const string& directory : stack) answer += "/" + directory; return answer.empty() ? "/" : answer;
    }
};
