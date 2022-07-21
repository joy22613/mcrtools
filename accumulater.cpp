#include<fstream>
#include<iostream>
#include<sstream>
using namespace std;
#define MAX_KB 32768
#define MAX_FILES 1000
int main(int argc,char** argv){
	fstream fbin(argv[1],ios_base::binary | ios_base::out),fbin2;
	char buf[1025];int files,numofKB;
	sscanf(argv[3],"%d",&numofKB);
	sscanf(argv[2],"%d",&files);
	if(!fbin.is_open() || files > MAX_FILES || numofKB > MAX_KB || files < 0 || numofKB < 0){
		cout << "ERROR" << 0x13267 << endl;
		return 0;
	}
	for(int i = 1;i <= files;i++){
		string filename = "bindump";
		stringstream tss = stringstream(filename,ios_base::app | ios_base::out | ios_base::ate);
		tss << i << ".hdump";
		filename = tss.str();
		cout << filename << endl;
		fbin2.open(filename,ios_base::binary | ios_base::in);
		if(!fbin2.is_open()){
			cout << "ERROR" << 0x13268 << endl;
			return 0;
		}
		for(int j = 1;j <= numofKB;j++){
			fbin2.read(buf,1024);
			fbin.write(buf,fbin2.gcount());
			if(fbin2.eof()) break;
		}
		fbin2.close();
	}
	fbin.close();
	return 0;
}
