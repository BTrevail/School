/* PROGRAM: lab4.c (lab4)
   AUTHOR: Byron, Trevail(Trev0023) 
   DATE: February 23, 2018
   PURPOSE: Simple Rental Sorting program
   LEVEL OF DIFFICULTY: 4
   CHALLENGES: Learning how to dereference pointers to structs.
   HOUR SPENT: 5+                                 
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

typedef struct {
int nRent;
int nRoomNum;
int nStreetNum;
char* sStreetName;
} Rental;

void swap( Rental* pRentals, int i ) {
	Rental temp = * ( pRentals + ( i + 1 ) );
	*( pRentals + ( i + 1 ) ) = *( pRentals + i );
	*( pRentals + i ) = temp;	
}

int compareRoom( Rental* pRentals, int i ){
	int dif = ( pRentals + i ) -> nRoomNum - ( pRentals + ( i + 1 ) ) -> nRoomNum;

	if ( ! dif ) {
		dif = ( pRentals + i ) -> nRent - ( pRentals + ( i + 1 ) ) -> nRent;
	}
	return dif;
}

int compareRent( Rental* pRentals, int i ) {
	int dif = ( pRentals + i ) -> nRent - ( pRentals + ( i + 1 ) ) -> nRent;

	if ( ! dif ) {
		dif = ( pRentals + i ) -> nRoomNum - ( pRentals + ( i + 1 ) ) -> nRoomNum;
	}
	return dif;
}

int compareStreet( Rental* pRentals, int i ) {
	int dif = strcmp( ( pRentals + i ) -> sStreetName, ( pRentals + ( i + 1 ) ) -> sStreetName );

	if ( ! dif ) {
		dif = ( pRentals + i ) -> nStreetNum - ( pRentals + ( i + 1 ) ) -> nStreetNum;
	}
	return dif;	
}

void sortRoom( Rental* pRentals ) {
	printf( "\n\n Sorted by Rooms\n" );

	for ( int i = 0; i < 10;i++ ) {
		for ( int ii = 0; ii < 11 - i; ii++ ) {
			if ( compareRoom( pRentals, ii ) > 0 ) {
				swap( pRentals, ii );
			}	
		}
	}
}

void sortRent( Rental* pRentals ) {
	printf( "\n\n Sorted by Rent\n" );

	for ( int i = 0; i < 10; i++ ) {
		for ( int ii = 0; ii < 11 - i; ii++ ) {
			if ( compareRent( pRentals, ii ) > 0 ) {
				swap( pRentals, ii );
			}	
		}
	}
}

void sortStreet( Rental* pRentals ) {
	printf( "\n\n Sorted by Address\n" );

	for ( int i = 0; i < 10; i++ ) {
		for ( int ii = 0; ii < 11 - i; ii++ ) {
			if ( compareStreet( pRentals, ii ) > 0 ) {
				swap( pRentals, ii );
			}	
		}
	}
}

void printList( Rental* pRentals ) {
	printf( " %-26s\t\t%7s\t%8s\n", "Address", "# Rooms", "Rent" );
	printf( " %-26s\t\t%7s\t%8s\n", "--------------------------", "-------", "-------" );

	for ( int i = 0; i < 12; i++ ) {
		printf( "%4d %-22s\t\t%7d\t%8d\n", ( pRentals + i ) -> nStreetNum, ( pRentals + i ) -> sStreetName, ( pRentals + i ) -> nRoomNum, ( pRentals + i ) -> nRent );
	}
}

void printAll( Rental* pRentals ) {
	sortRoom( pRentals );
	printList( pRentals );
	sortRent( pRentals );
	printList( pRentals );
	sortStreet( pRentals );
	printList( pRentals );
}

char* getStreet( int i ) {//Get a street name, i wasnt sure what was considered a line so i put this in a separate function.
	char* streets[] = {
		"Sussex Drive",
		"Mill Street",
		"Andrew Avenue",
		"Baseline Road",
		"Main Street",
		"Castor Street",
		"Random Crecent",
		"Fake Street",
		"Conch Street",
		"Trung Trail",
		"Repetto Road",
		"Gabe Boolevard",
		"Mourt Court",
		"Nicholas Street"
	};
	return streets[i];
}

int main() {
	const int MAX = 14;
	srand ( time ( NULL ) );
	Rental rentals[] = {
		{ ( ( rand() % 9 ) + 4 ) * 100, ( rand() % 4 ) + 1, 24, getStreet( 0 ) },
    	{ ( ( rand() % 9 ) + 4 ) * 100, ( rand() % 4 ) + 1, 1, getStreet( 0 ) },
		{ ( ( rand() % 9 ) + 4 ) * 100, ( rand() % 4 ) + 1, 5, getStreet( 0 ) },
		{ ( ( rand() % 9 ) + 4 ) * 100, ( rand() % 4 ) + 1, ( rand() % 999 ) + 1, getStreet( 1 ) },
    	{ ( ( rand() % 9 ) + 4 ) * 100, ( rand() % 4 ) + 1, ( rand() % 999 ) + 1, getStreet( 1 ) },
		{ ( ( rand() % 9 ) + 4 ) * 100, ( rand() % 4 ) + 1, ( rand() % 999 ) + 1, getStreet( rand() % MAX ) },
		{ ( ( rand() % 9 ) + 4 ) * 100, ( rand() % 4 ) + 1, ( rand() % 999 ) + 1, getStreet( rand() % MAX ) },
		{ ( ( rand() % 9 ) + 4 ) * 100, ( rand() % 4 ) + 1, ( rand() % 999 ) + 1, getStreet( rand() % MAX ) },
		{ ( ( rand() % 9 ) + 4 ) * 100, ( rand() % 4 ) + 1, ( rand() % 999 ) + 1, getStreet( rand() % MAX ) },
		{ ( ( rand() % 9 ) + 4 ) * 100, ( rand() % 4 ) + 1, ( rand() % 999 ) + 1, getStreet( rand() % MAX ) },
		{ ( ( rand() % 9 ) + 4 ) * 100, ( rand() % 4 ) + 1, ( rand() % 999 ) + 1, getStreet( rand() % MAX ) },
		{ ( ( rand() % 9 ) + 4 ) * 100, ( rand() % 4 ) + 1, ( rand() % 999 ) + 1, getStreet( rand() % MAX ) }	
	};
	printAll ( rentals );
}