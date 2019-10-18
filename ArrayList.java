import java.util.Arrays;
import java.util.EmptyStackException;
public class ArrayList<T> implements List<T>{
	
	protected T[]a;
	public int N=0;

	public int size(){
		return N;
	}

	@SuppressWarnings("unchecked")
	public ArrayList(){
		a = (T[]) (new Object[10]);
		
	}

	public void add(T item){
		if(size()==a.length){
			grow_array();
		}
		a[N++]=item;
	}
	public void add(int pos, T item){
		if(pos<0 || pos>size()){
			throw new EmptyStackException();

		}
		if(size()== a.length){
			grow_array();
		}
		for(int i = size()-1;i>pos;i--){
			a[i+1]=a[i];
		}
		a[pos]=item;
		++N;
	}
	public T get(int pos){
		if(pos>= size() || pos<0){
			throw new EmptyStackException();
		}
		return a[pos];
	}
	public T remove(int pos){
		if(pos<0|| pos>size()){
			throw new EmptyStackException();
		}
		T temp =a[pos];
		for(int i=pos;i<size()-1;i++){
			a[i]=a[i+1];
		}
		--N;
		return temp;
	}
	public void grow_array(){
		@SuppressWarnings("unchecked")
		T[] larger =(T[]) new Object [a.length*2];
		for(int i =0 ; i<a.length;i++ ){
			larger[i]= a[i];

		}
		a= larger;
	}






}