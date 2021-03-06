/*
CH08-320143
Problem a5.p4.cpp
Jonathan Rittmayer
jo.rittmayer@jacobs-university.de

Consider the slides from Lecture 5 & 6 (pages 3 − 9) as additional explanation.
Reorganize the code such that each class is put into its own header file and the corresponding
implementation into its own cpp file. Then put the main function into another cpp file. You
will possibly need to include several other classes for several files. Do not use std namespace in
header files, but change the code accordingly (e.g., std::cout). You might also need guards via
conditional compilation in your header files.
*/

#include "House.h"

House::House(const std::string& name):
GenericPlayer(name){

}

House::~House(){

}

bool House::IsHitting() const{
  return (GetTotal() <= 16);
}

void House::FlipFirstCard(){
  if (!(m_Cards.empty())){
    m_Cards[0]->Flip();
  }
  else{
    std::cout << "No card to flip!\n";
  }
}
