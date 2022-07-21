#include<fstream>
#include<iostream>
#include<sstream>
using namespace std;
#define MAX_KB 32768
#define MAX_FILES 1000
int main(int argc,char** argv){
	fstream fbin(argv[1],ios_base::binary | ios_base::in),fbin2;
	char buf[1025];int files = 0,numofKB = 0;
	sscanf(argv[3],"%d",&numofKB);
	sscanf(argv[2],"%d",&files);
	if(!fbin.is_open() || files > MAX_FILES || numofKB > MAX_KB || files < 0 || numofKB < 0){
		throw 0x13367;
		return 0;
	}
	for(int i = 1;i <= files && i <= 1000;i++){
		if(fbin.eof()) break;
		string filename = "bindump";
		stringstream tss = stringstream(filename,ios_base::app | ios_base::out | ios_base::ate);
		tss << i << ".hdump";
		filename = tss.str();
		cout << filename << endl;
		fbin2.open(filename,ios_base::binary | ios_base::out);
		if(!fbin2.is_open()){
			throw 0x13368;
			return 0;
		}
		for(int j = 1;j <= numofKB;j++){
			fbin.read(buf,1024);
			fbin2.write(buf,fbin.gcount());
			if(fbin.eof()) break;
		}
		fbin2.close();
	}
	fbin.close();
	return 0;
}
