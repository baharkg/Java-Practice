
global size, board, mines

def create_board(board_size, num_mines):
	size=board_size
	#board_size=[5,7]
	board=[]
	for i in range(board_size[0]):
		board.append([0]*board_size[1])

create_board([3,7],5)
