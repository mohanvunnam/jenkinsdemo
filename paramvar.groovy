def PushDrContainers(){
	// Boolean
	PushDrContainers = 'true'
}

def api_imagetag(){
    // string
	api_imagetag = 'latest'
}

def sso_imagetag(){
	// string
	sso_imagetag = 'latest'
}

def iav_imagetag(){
	// string
	iav_imagetag = 'latest'
}

def ontrac_imagetag(){
	// string
	ontrac_imagetag = 'latest'
}

def ebill_imagetag(){
	// string
	ebill_imagetag = 'latest'
}

def recipient_imagetag(){
	// string
	recipient_imagetag = 'latest'
}


def environment(){
	// Choice
	environment = 'prod'
}


def nbr_api_ec2(){
	// string
	nbr_api_ec2 = '1'
}

nbr_ui_ec2
def nbr_ui_ec2(){
	// string
	nbr_ui_ec2 = '1'
}


def update_sso(){
	// Choice
	update_sso = 'no'
}

def update_api(){
	// Choice
	update_api = 'no'
}

def update_iav(){
	// Choice
	update_iav = 'no'
}

def update_ontrac(){
	// Choice
	update_ontrac = 'no'
}

def update_ebill(){
	// Choice
	update_ebill = 'no'
}

def update_recipient(){
	// Choice
	update_recipient = 'no'
}



//
//def approval(){
//	approval = 'true'
//}



def tfbranch(){
	tfbranch = 'false'
}


def cybersource_loopback(){
	// Boolean
	cybersource_loopback = 'false'
}

def dc_dcu_loopback(){
	// Boolean
	dc_dcu_loopback = 'false'
}

def dc_dna_3rivers_loopback(){
	// Boolean
	dc_dna_3rivers_loopback = 'false'
}

def dc_dna_meritrust_loopback(){
	// Boolean
	dc_dna_meritrust_loopback = 'false'
}

def dc_cocc_reading_loopback(){
	// Boolean
	dc_cocc_reading_loopback = 'false'
}

def dc_mahalo_profed_loopback(){
	// Boolean
	dc_mahalo_profed_loopback = 'false'
}

def dc_episys_coastal_loopback(){
	// Boolean
	dc_episys_coastal_loopback = 'false'
}

def dc_episys_dover_loopback(){
	// Boolean
	dc_episys_dover_loopback = 'false'
}

def dc_episys_publix_loopback(){
	// Boolean
	dc_episys_publix_loopback = 'false'
}

def dc_episys_unitus_loopback(){
	// Boolean
	dc_episys_unitus_loopback = 'false'
}

def dc_finxact_primis_loopback(){
	// Boolean
	dc_finxact_primis_loopback = 'false'
}

def dc_q2_mercantile_loopback(){
	// Boolean
	dc_q2_mercantile_loopback = 'false'
}

def rce_worker_loopback(){
	// Boolean
	rce_worker_loopback = 'false'
}

def venmo_loopback(){
	// Boolean
	venmo_loopback = 'false'
}

def bpx_loopback(){
	// Boolean
	bpx_loopback = 'false'
}

def dc_cocc_libertybank_loopback(){
	// Boolean
	dc_cocc_libertybank_loopback = 'false'
}

def dc_xp2_nusenda_loopback(){
	// Boolean
	dc_xp2_nusenda_loopback = 'false'
}

def dc_episys_wrightpatt_loopback(){
	// Boolean
	dc_episys_wrightpatt_loopback = 'false'
}

def dc_episys_eecu_loopback(){
	// Boolean
	dc_episys_eecu_loopback = 'false'
}

def dc_q2_firstnorthernbank_loopback(){
	// Boolean
	dc_q2_firstnorthernbank_loopback = 'false'
}

def dc_q2_5star_loopback(){
	// Boolean
	dc_q2_5star_loopback = 'false'
}

def dc_finxact_glorifi_loopback(){
	// Boolean
	dc_finxact_glorifi_loopback = 'false'
}

def dc_keystone_cenwill_loopback(){
	// Boolean
	dc_keystone_cenwill_loopback = 'false'
}

def dc_episys_hudsonvalley_loopback(){
	// Boolean
	dc_episys_hudsonvalley_loopback = 'false'
}

def dc_episys_kinecta_loopback(){
	// Boolean
	dc_episys_kinecta_loopback = 'false'
}

def dc_episys_georgiaunited_loopback(){
	// Boolean
	dc_episys_georgiaunited_loopback = 'false'
}

def dc_q2_chesapeakebank_loopback(){
	// Boolean
	dc_q2_chesapeakebank_loopback = 'false'
}



//def nbr_api_ec2(){
	// string
//	nbr_api_ec2 = '1'
//}

//def nbr_ui_ec2(){
	// string
//	nbr_ui_ec2 = '1'
//}



def should_roll(){
	// string
	should_roll = 'false'
}


return this
